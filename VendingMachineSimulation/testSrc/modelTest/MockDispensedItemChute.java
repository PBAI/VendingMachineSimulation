package modelTest;

import java.util.ArrayList;

import model.DispensedItemChuteInterface;
import model.DispensibleItem;

public class MockDispensedItemChute implements DispensedItemChuteInterface {

	private boolean clearDispensedItemChuteWasCalled;
	private boolean addItemToChuteWasCalled;
	private boolean getDispensedItemsWasCalled;

	public MockDispensedItemChute() {
		this.clearDispensedItemChuteWasCalled = false;
		this.addItemToChuteWasCalled = false;
		this.getDispensedItemsWasCalled = false;
	}

	@Override
	public void clearDispensedItemChute() {
		this.clearDispensedItemChuteWasCalled = true;
	}

	@Override
	public ArrayList<DispensibleItem> getDispensedItems() {
		this.getDispensedItemsWasCalled = true;
		return null;
	}

	@Override
	public void addItemToChute(DispensibleItem itemToDispense) {
		this.addItemToChuteWasCalled = true;
	}

	public boolean getClearDispensedItemChuteWasCalled() {
		return this.clearDispensedItemChuteWasCalled;
	}

	public boolean getAddItemToChuteWasCalled() {
		return addItemToChuteWasCalled;
	}

	public boolean getGetDispensedItemsWasCalled() {
		return getDispensedItemsWasCalled;
	}
}
