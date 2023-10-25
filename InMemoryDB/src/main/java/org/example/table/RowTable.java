package org.example.table;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.example.api.DML;
import org.example.api.DQL;
import org.example.api.DataRow;
import org.example.indexes.Index;
import org.example.indexes.IndexType;
import org.example.schema.TableSchema;

public class RowTable implements  DML {

	private String tableName;
	private TableSchema tableSchema; // assuming you have a TableSchema class
	private Map<String, Index> indexes;
	private String primaryKey;

	private Map<Object, DataRow> tableRowData;


	public RowTable(String tableName, TableSchema tableSchema, String primaryKey) {
		this.tableName = tableName;
		this.tableSchema = tableSchema;
		this.indexes = new HashMap<>();
		this.primaryKey = primaryKey;
		this.tableRowData = new HashMap<>();
	}

	public void createIndex(String columnName, IndexType indexType) {
		if (indexes.containsKey(columnName)) {
			throw new IllegalArgumentException("Index already exists: " + columnName);
		}
		indexes.put(columnName, indexType.createInstance(columnName, primaryKey)); // Assuming IndexType can create instances of Index
	}

	public void insertData(Map<String, Object> rowData) {
		tableSchema.validateRowData(rowData); // assuming you have a validateRowData method in TableSchema class
		DataRow newRow = new DataRow(rowData);
		newRow.getLock().writeLock().lock();
		try {
			tableRowData.put(rowData.get(primaryKey), new DataRow(rowData));
			indexRowData(rowData);
		}finally {
			newRow.getLock().writeLock().unlock();
		}
	}

	private void indexRowData(Map<String, Object> rowData) {
		for (String index : indexes.keySet()) {
			if (rowData.containsKey(index)) {
				indexes.get(index).indexRowData(rowData);
			}
		}
	}

	public void updateData(String key, Map<String, Object> newData) {
		DataRow existingRow = tableRowData.get(key);

		existingRow.getLock().writeLock().lock();
		try {
			existingRow.getData().putAll(newData);
		} finally {
			existingRow.getLock().writeLock().unlock();
		}
	}


	public void deleteData(String key) {
		if (!tableRowData.containsKey(key)) {
			throw new IllegalArgumentException("Record not present with key: " + primaryKey);
		}
		DataRow existingRow = tableRowData.get(key);
		existingRow.getLock().writeLock().lock();
		try {
			indexes.entrySet().stream()
					.filter(entry -> existingRow.getData().containsKey(entry.getKey()))
					.forEach(entry -> entry.getValue().removeIndexedVal(existingRow.getData()));
			tableRowData.remove(key);
		} finally {
			existingRow.getLock().writeLock().unlock();
		}
	}


}
