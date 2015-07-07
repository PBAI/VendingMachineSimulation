package model;

public class VendingSlotCollection {

	private final VendingSlotInterface vendingSlotA;
	private final VendingSlotInterface vendingSlotB;
	private final VendingSlotInterface vendingSlotC;

	public VendingSlotCollection(VendingSlotInterface vendingSlotA,
			VendingSlotInterface vendingSlotB, VendingSlotInterface vendingSlotC) {
		this.vendingSlotA = vendingSlotA;
		this.vendingSlotB = vendingSlotB;
		this.vendingSlotC = vendingSlotC;
	}

	public VendingSlotInterface getVendingSlotA() {
		return this.vendingSlotA;
	}

	public VendingSlotInterface getVendingSlotB() {
		return this.vendingSlotB;
	}

	public VendingSlotInterface getVendingSlotC() {
		return this.vendingSlotC;
	}
}
