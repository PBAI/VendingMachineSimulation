package model;

public class VendingSlot implements VendingSlotInterface {

	private final DispensibleItem itemForSlot;
	private int productQuantity;

	public VendingSlot(DispensibleItem itemForSlot, int productQuantity) {
		this.itemForSlot = itemForSlot;
		this.productQuantity = productQuantity;
	}

	@Override
	public DispensibleItem getDispensibleItem() {
		return this.itemForSlot;
	}

	@Override
	public int getProductQuantity() {
		return this.productQuantity;
	}

	@Override
	public void subtractProductQuantityByOne() {
		this.productQuantity--;
	}

}
