package org.example.indexes;

public enum IndexType {

	REVERSE_INDEX {
		@Override
		public Index createInstance(String indexColName, String primaryKeyName) {
			return new ReverseIndex(indexColName, primaryKeyName);
		}
	};

	public abstract Index createInstance(String indexColName, String primaryKeyName);

}
