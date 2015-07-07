package model;

public class ProductQuantities implements ProductQuantitiesInterface {

	private int productA_Quantity;
	private int productB_Quantity;
	private int productC_Quantity;

	public ProductQuantities() {
		this.productA_Quantity = 3;
		this.productB_Quantity = 2;
		this.productC_Quantity = 4;
	}

	@Override
	public int getProductAQuantity() {
		return this.productA_Quantity;
	}

	@Override
	public int getProductBQuantity() {
		return this.productB_Quantity;
	}

	@Override
	public int getProductCQuantity() {
		return this.productC_Quantity;
	}

	@Override
	public void subtractProductAQuantityByOne() {
		this.productA_Quantity--;
	}

	@Override
	public void subtractProductBQuantityByOne() {
		this.productB_Quantity--;
	}

	@Override
	public void subtractProductCQuantityByOne() {
		this.productC_Quantity--;
	}
}
