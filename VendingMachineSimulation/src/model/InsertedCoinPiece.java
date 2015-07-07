package model;

public enum InsertedCoinPiece {

	PENNY(19.05, 2.5), NICKEL(21.21, 5), DIME(17.9, 2.268), QUARTER(24.26, 5.67), SLUG(25.8, 8.21);

	private double diameterInMillimeters;
	private double weightInGrams;

	private InsertedCoinPiece(double diameterInMillimeters, double weightInGrams) {
		this.diameterInMillimeters = diameterInMillimeters;
		this.weightInGrams = weightInGrams;
	}

	public double diameterInMillimeters() {
		return this.diameterInMillimeters;
	}

	public double weightInGrams() {
		return this.weightInGrams;
	}

}
