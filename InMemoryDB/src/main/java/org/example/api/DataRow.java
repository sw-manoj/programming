package org.example.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataRow {
	private final Map<String, Object> data;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public DataRow(Map<String, Object> initialData) {
		this.data = new HashMap<>(initialData);
	}

	public ReadWriteLock getLock() {
		return lock;
	}

	public Map<String, Object> getData() {
		return data;
	}

	// ... other utility methods related to DataRow if needed ...
}
