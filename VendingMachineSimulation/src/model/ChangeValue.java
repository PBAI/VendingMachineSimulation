package model;

import java.text.DecimalFormat;

public class ChangeValue implements ChangeValueInterface {

	private double total;

	public ChangeValue() {
		this.total = 0.00;
	}

	@Override
	public void addToTotal(double amountToAdd) {
		this.total += amountToAdd;
	}

	@Override
	public String getTotalAsFormattedString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String totalAsFormattedString = decimalFormat.format(this.total);
		return totalAsFormattedString;
	}

	@Override
	public void clearTotal() {
		this.total = 0.00;
	}

	public double getTotal() {
		return this.total;
	}
}
