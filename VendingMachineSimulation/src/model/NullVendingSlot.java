package model;

public class NullVendingSlot implements VendingSlotInterface {

	DispensibleItem itemForSlot;
	int productQuantity;

	public NullVendingSlot(DispensibleItem itemForSlot, int productQuantity) {
		this.itemForSlot = itemForSlot;
		this.productQuantity = productQuantity;
	}

	@Override
	public int getProductQuantity() {
		return this.productQuantity;
	}

	@Override
	public DispensibleItem getDispensibleItem() {
		return this.itemForSlot;
	}

	@Override
	public void subtractProductQuantityByOne() {

	}

}
