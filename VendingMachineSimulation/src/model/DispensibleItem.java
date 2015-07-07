package model;

public enum DispensibleItem {

	COLA(1.00, "cola"), CHIPS(.50, "chips"), CANDY(.65, "candy"), NULL(0.00, "nothing");

	private double priceOfItem;
	private final String nameOfItem;

	private DispensibleItem(double itemPrice, String nameOfItem) {
		this.priceOfItem = itemPrice;
		this.nameOfItem = nameOfItem;
	}

	public double priceOfItem() {
		return this.priceOfItem;
	}

	public String nameOfItem() {
		return this.nameOfItem;
	}
}
