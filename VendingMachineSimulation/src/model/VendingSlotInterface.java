package model;

public interface VendingSlotInterface {

	public abstract int getProductQuantity();

	public abstract DispensibleItem getDispensibleItem();

	public abstract void subtractProductQuantityByOne();

}
