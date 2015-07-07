package controlTest;

import control.VendingControllerInterface;

public class MockVendingController implements VendingControllerInterface {

	private boolean vendProductWasCalled;
	private int vendingButtonIndex;

	public MockVendingController() {
		this.vendProductWasCalled = false;
	}

	@Override
	public void vendProduct(int vendingButtonIndex) {
		this.vendProductWasCalled = true;
		this.vendingButtonIndex = vendingButtonIndex;
	}

	public boolean getVendProductWasCalled() {
		return this.vendProductWasCalled;
	}

	public int getVendingButtonIndex() {
		return this.vendingButtonIndex;
	}

}
