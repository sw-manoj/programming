package org.example.api;

import java.util.Map;

import org.example.indexes.IndexType;

public interface DML {

	void createIndex(String columnName, IndexType indexType);
	void insertData(Map<String, Object> rowData);
	void deleteData(String key);
}
