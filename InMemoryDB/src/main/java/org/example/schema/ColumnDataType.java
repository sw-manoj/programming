package org.example.schema;

public abstract class ColumnDataType<T> {

	private Class<T> dataType;

	public ColumnDataType(Class<T> dataType) {
		this.dataType = dataType;
	}

	public T validate(T val) {
		if (!dataType.isInstance(val)) {
			throw new RuntimeException("Invalid_data_point_type");
		}
		return val;
	}
}
