package model;

public enum ValidCoin {

	NICKEL(21.21, 5, .05), DIME(17.9, 2.268, .10), QUARTER(24.26, 5.67, .25);

	private double diameterInMillimeters;
	private double weightInGrams;
	private double valueInCents;

	private ValidCoin(double diameterInMillimeters, double weightInGrams, double valueInCents) {
		this.diameterInMillimeters = diameterInMillimeters;
		this.weightInGrams = weightInGrams;
		this.valueInCents = valueInCents;
	}

	public double diameterInMillimeters() {
		return this.diameterInMillimeters;
	}

	public double weightInGrams() {
		return this.weightInGrams;
	}

	public double valueInCents() {
		return this.valueInCents;
	}

}
