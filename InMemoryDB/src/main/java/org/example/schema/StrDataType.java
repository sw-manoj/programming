package org.example.schema;


public class StrDataType extends ColumnDataType<String> {
	private int minLength;
	private int maxLength;

	public StrDataType(int minLength, int maxLength) {
		super(String.class);
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	@Override
	public String validate(String val) {
		super.validate(val);
		int len = val.length();
		if (len < minLength || len > maxLength) {
			throw new RuntimeException("string_len_out_of_range");
		}
		return val;
	}
}
