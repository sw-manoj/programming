package org.example.schema;

public class IntDataType  extends ColumnDataType<Integer>{
	private int minValue;
	private int maxValue;

	public IntDataType(int minValue, int maxValue) {
		super(Integer.class);
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public Integer validate(Integer val) {
		super.validate(val);
		if (val < minValue || val > maxValue) {
			throw new RuntimeException("int_out_of_range");
		}
		return val;
	}
}
