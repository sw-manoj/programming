package org.example.schema;

public class SchemaMember<T> {
	private String columnName;
	private ColumnDataType<T> columnType;
	private boolean required;
	private boolean allowNone;

	public SchemaMember(String columnName, ColumnDataType<T> columnType, boolean required, boolean allowNone) {
		this.columnName = columnName;
		this.columnType = columnType;
		this.required = required;
		this.allowNone = allowNone;
	}

	public T validateValue(T val) {
		if (val == null && !allowNone) {
//			throw new InvalidValueException("None_not_allowed_in_" + columnName);
			throw new RuntimeException("None_not_allowed_in_" + columnName);

		}
		return columnType.validate(val);
	}

	public ColumnDataType<T> getColumnType() {
		return columnType;
	}

	public String getColumnName() {
		return columnName;
	}

	public boolean isRequired() {
		return required;
	}

	public boolean isAllowNone() {
		return allowNone;
	}
}
