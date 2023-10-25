package org.example.indexes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseIndex<K, V> extends Index<K, V> {
	public ReverseIndex(String indexName, String primaryKey) {
		super(indexName, primaryKey);
	}

	@Override
	protected void indexData(Map<K, V> rowData) {
		var indexVal = rowData.get(indexName);
		if(indexVal == null) {
			return;
		}
		indexStorage
				.computeIfAbsent((K) indexVal, k -> new HashSet<V>())
				.add(rowData.get(primaryKey));
	}

	@Override
	public void removeIndexedVal(Map<K, V> rowData) {
		Set<V> indexSet = indexStorage.get(rowData.get(indexName));
		if (indexSet != null) {
			indexSet.remove(rowData.get(primaryKey));
		}
	}
}