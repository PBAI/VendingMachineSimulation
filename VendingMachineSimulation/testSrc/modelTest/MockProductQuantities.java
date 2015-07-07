package modelTest;

import model.ProductQuantitiesInterface;

public class MockProductQuantities implements ProductQuantitiesInterface {

	private boolean subtractProductCQuantityByOneWasCalled;
	private boolean subtractProductBQuantityByOneWasCalled;
	private boolean subtractProductAQuantityByOneWasCalled;
	private boolean getProductAQuantityWasCalled;
	private boolean getProductBQuantityWasCalled;
	private boolean getProductCQuantityWasCalled;

	public MockProductQuantities() {
		this.subtractProductAQuantityByOneWasCalled = false;
		this.subtractProductBQuantityByOneWasCalled = false;
		this.subtractProductCQuantityByOneWasCalled = false;
		this.getProductAQuantityWasCalled = false;
		this.getProductBQuantityWasCalled = false;
		this.getProductCQuantityWasCalled = false;
	}

	@Override
	public void subtractProductCQuantityByOne() {
		this.subtractProductCQuantityByOneWasCalled = true;
	}

	@Override
	public void subtractProductBQuantityByOne() {
		this.subtractProductBQuantityByOneWasCalled = true;
	}

	@Override
	public void subtractProductAQuantityByOne() {
		this.subtractProductAQuantityByOneWasCalled = true;
	}

	@Override
	public int getProductCQuantity() {
		this.getProductCQuantityWasCalled = true;
		return 0;
	}

	@Override
	public int getProductBQuantity() {
		this.getProductBQuantityWasCalled = true;
		return 0;
	}

	@Override
	public int getProductAQuantity() {
		this.getProductAQuantityWasCalled = true;
		return 0;
	}

	public boolean getSubtractProductAQuantityByOneWasCalled() {
		return this.subtractProductAQuantityByOneWasCalled;
	}

	public boolean getSubtractProductBQuantityByOneWasCalled() {
		return this.subtractProductBQuantityByOneWasCalled;
	}

	public boolean getSubtractProductCQuantityByOneWasCalled() {
		return this.subtractProductCQuantityByOneWasCalled;
	}

	public boolean getGetProductAQuantityWasCalled() {
		return this.getProductAQuantityWasCalled;
	}

	public boolean getGetProductBQuantityWasCalled() {
		return this.getProductBQuantityWasCalled;
	}

	public boolean getGetProductCQuantityWasCalled() {
		return this.getProductCQuantityWasCalled;
	}
}
