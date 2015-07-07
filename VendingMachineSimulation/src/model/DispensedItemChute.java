package model;

import java.util.ArrayList;

public class DispensedItemChute implements DispensedItemChuteInterface {

	ArrayList<DispensibleItem> dispensedItems;

	public DispensedItemChute() {
		this.dispensedItems = new ArrayList<DispensibleItem>();
	}

	@Override
	public void addItemToChute(DispensibleItem itemToDispense) {
		this.dispensedItems.add(itemToDispense);
	}

	@Override
	public ArrayList<DispensibleItem> getDispensedItems() {
		return this.dispensedItems;
	}

	@Override
	public void clearDispensedItemChute() {
		this.dispensedItems.clear();
	}

}
