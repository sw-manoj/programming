package org.example.table;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.example.api.DML;
import org.example.api.DQL;
import org.example.api.DataRow;
import org.example.indexes.Index;
import org.example.indexes.IndexType;
import org.example.schema.TableSchema;


public class Table implements DQL, DML {

	private String tableName;
	private TableSchema tableSchema; // assuming you have a TableSchema class
	private Map<String, Index> indexes;
	private String primaryKey;
	private Map<String, Map<String, Object>> tableData;

	private Map<Object, DataRow> tableRowData;


	public Table(String tableName, TableSchema tableSchema, String primaryKey) {
		this.tableName = tableName;
		this.tableSchema = tableSchema;
		this.indexes = new HashMap<>();
		this.primaryKey = primaryKey;
		this.tableData = new HashMap<>();
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
		tableData.put((String) rowData.get(primaryKey), rowData);
		tableRowData.put(rowData.get(primaryKey), new DataRow(rowData));
		indexRowData(rowData);
	}

	private void indexRowData(Map<String, Object> rowData) {
		for (String index : indexes.keySet()) {
			if (rowData.containsKey(index)) {
				indexes.get(index).indexRowData(rowData);
			}
		}
	}

	public void deleteData(String key) {
		if (!tableData.containsKey(key)) {
			throw new IllegalArgumentException("Record not present with key: " + primaryKey);
		}
		Map<String, Object> data = tableData.remove(key);
		indexes.entrySet().stream()
				.filter(entry -> data.containsKey(entry.getKey()))
				.forEach(entry -> entry.getValue().removeIndexedVal(data));
	}

	@Override
	public DQL join(DQL otherTable, String thisColumn, String otherColumn) {
		if (!(otherTable instanceof Table)) {
			throw new IllegalArgumentException("Unsupported table type.");
		}

		Table other = (Table) otherTable;
		// Sample join logic, implementing INNER JOIN
		Map<String, Map<String, Object>> joinedData = new HashMap<>();

		for (Map<String, Object> thisRow : this.tableData.values()) {
			for (Map<String, Object> otherRow : other.tableData.values()) {
				if (thisRow.get(thisColumn).equals(otherRow.get(otherColumn))) {
					Map<String, Object> joinedRow = new HashMap<>(thisRow);
					joinedRow.putAll(otherRow); // This will simply merge the two rows.
					joinedData.put((String)joinedRow.get(this.primaryKey), joinedRow);
				}
			}
		}

		Table joinedTable = new Table(this.tableName + "_joined_" + other.tableName, this.tableSchema, this.primaryKey);
		// You might want to merge schemas or handle it in some other way.
		joinedTable.tableData = joinedData;
		return joinedTable;
	}


	public List<Map<String, Object>> filterData1(Map<String, Object> filters) {
		if (filters.containsKey(primaryKey)) {
			return tableData.containsKey((String) filters.get(primaryKey))
					? Collections.singletonList(tableData.get(filters.get(primaryKey)))
					: Collections.emptyList();
		}

		List<String> hasIndexes = filters.keySet().stream()
				.filter(indexes::containsKey)
				.collect(Collectors.toList());

		Map<String, Object> noIndexFilters = filters.entrySet().stream()
				.filter(entry -> !indexes.containsKey(entry.getKey()))
				.collect(Collectors.toMap(k -> k.getKey(), k -> k.getValue()));

		Set<String> filteredData = filterOnIndexes(filters, hasIndexes);
		List<Map<String, Object>> indexedFilteredData = filteredData.stream()
				.map(tableData::get)
				.collect(Collectors.toList());


		return scanTable(noIndexFilters, hasIndexes.isEmpty() ? tableData.values() : indexedFilteredData);
	}
	// Sample scanTable method
	private List<Map<String, Object>> scanTable(Map<String, Object> filters, Collection<Map<String, Object>> data) {
		return data.stream()
				.filter(row -> filters.entrySet().stream()
						.allMatch(filter -> row.containsKey(filter.getKey()) && filter.getValue().equals(row.get(filter.getKey())))
				)
				.collect(Collectors.toList());
	}

	// Sample filterOnIndexes method
	private Set<String> filterOnIndexes(Map<String, Object> filters, List<String> hasIndexes) {
		return hasIndexes.stream()
				.map(filterKey -> indexes.get(filterKey).getData(filters.get(filterKey)))
				.reduce((a, b) -> {
					Set<String> intersection = new HashSet<>(a);
					intersection.retainAll(b);
					return intersection;
				})
				.orElse(Collections.emptySet());
	}

	@Override
	public DQL filterData(Map<String, Object> filters) {
		List<Map<String, Object>> filteredDataList = scanTable(filters, this.tableData.values());

		Table filteredTable = new Table(this.tableName + "_filtered", this.tableSchema, this.primaryKey);
		// Using suffix "_filtered" for the sake of differentiation.
		for (Map<String, Object> row : filteredDataList) {
			filteredTable.insertData(row);
		}

		return filteredTable;
	}

	@Override
	public List<Map<String, Object>> select() {
		return new ArrayList<>(this.tableData.values());
	}

	@Override
	public List<Map<String, Object>> select(List<String> fields) {
		return tableData.values().stream()
				.map(row -> fields.stream()
						.filter(row::containsKey)
						.collect(Collectors.toMap(Function.identity(), row::get)))
				.collect(Collectors.toList());
	}


}

