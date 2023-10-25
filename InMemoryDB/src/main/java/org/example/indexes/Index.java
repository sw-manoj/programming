package org.example.indexes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Index<K, V> {
	protected String indexName;
	protected String primaryKey;
	protected TreeMap<K, Set<V>> indexStorage;

	public Index(String indexName, String primaryKey) {
		this.indexName = indexName;
		this.primaryKey = primaryKey;
		this.indexStorage = new TreeMap<>();
	}

	public void indexRowData(Map<K, V> rowData) {
		removeIndexedVal(rowData);
		indexData(rowData);
	}

	protected abstract void indexData(Map<K, V> rowData);
	public Set<V> getData(K filterVal) {
		return indexStorage.getOrDefault(filterVal, new HashSet<>());
	}
	public abstract void removeIndexedVal(Map<K, V> rowData);
}