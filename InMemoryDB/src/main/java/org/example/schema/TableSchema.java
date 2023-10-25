package org.example.schema;

import java.util.HashMap;
import java.util.Map;

// Import or define the required exceptions
class MissingValueException extends RuntimeException {
	public MissingValueException(String message) {
		super(message);
	}
}

class UndefinedSchemaMember extends RuntimeException {
	public UndefinedSchemaMember(String message) {
		super(message);
	}
}

// Import the previously provided SchemaMember and ColumnDataType classes
// If they are in a separate package, they should be imported here.

public class TableSchema<T> {
	private Map<String, SchemaMember<T>> schemaMembers = new HashMap<>();
	private boolean allowUndefined;

	public TableSchema(boolean allowUndefined) {
		this.allowUndefined = allowUndefined;
	}

	public void addSchemaMember(SchemaMember<T> schemaMember) {
		schemaMembers.put(schemaMember.getColumnName(), schemaMember);
	}

	public Map<String, T> validateRowData(Map<String, T> rowData) {
		Map<String, T> validatedData = new HashMap<>();
		for (String colName : rowData.keySet()) {
			if (!schemaMembers.containsKey(colName) && !allowUndefined) {
				throw new UndefinedSchemaMember("undefined_schema_member_" + colName);
			}
			if (!schemaMembers.containsKey(colName)) {
				validatedData.put(colName, rowData.get(colName));
				continue;
			}
			validatedData.put(colName, schemaMembers.get(colName).validateValue(rowData.get(colName)));
		}

		for (String colName : schemaMembers.keySet()) {
			if (schemaMembers.get(colName).isRequired() && !rowData.containsKey(colName)) {
				throw new MissingValueException("col_name_" + colName + "_missing");
			}
		}
		return validatedData;
	}
}
