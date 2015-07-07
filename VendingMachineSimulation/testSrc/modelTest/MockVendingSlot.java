package modelTest;

import model.DispensibleItem;
import model.VendingSlotInterface;

public class MockVendingSlot implements VendingSlotInterface {

	private int productQuantity;
	private boolean getProductQuantityWasCalled;
	private boolean subtractProductQuantityByOneWasCalled;
	private boolean getDispensibleItemWasCalled;
	private DispensibleItem dispensibleItem;

	public MockVendingSlot() {
		this.productQuantity = 0;
		this.getProductQuantityWasCalled = false;
		this.subtractProductQuantityByOneWasCalled = false;
		this.getDispensibleItemWasCalled = false;
		this.dispensibleItem = null;
	}

	@Override
	public int getProductQuantity() {
		this.getProductQuantityWasCalled = true;
		return this.productQuantity;
	}

	@Override
	public DispensibleItem getDispensibleItem() {
		this.getDispensibleItemWasCalled = true;
		return this.dispensibleItem;
	}

	@Override
	public void subtractProductQuantityByOne() {
		this.subtractProductQuantityByOneWasCalled = true;
		this.productQuantity--;
	}

	public boolean getGetProductQuantityWasCalled() {
		return this.getProductQuantityWasCalled;
	}

	public boolean getSubtractProductQuantityByOneWasCalled() {
		return this.subtractProductQuantityByOneWasCalled;
	}

	public void setProductQuantity(int quantityToSet) {
		this.productQuantity = quantityToSet;
	}

	public void setDispensibleItemToReturn(DispensibleItem itemToReturn) {
		this.dispensibleItem = itemToReturn;
	}

	public boolean getGetDispensibleItemWasCalled() {
		return this.getDispensibleItemWasCalled;
	}

}
