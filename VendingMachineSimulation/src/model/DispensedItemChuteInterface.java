package model;

import java.util.ArrayList;

public interface DispensedItemChuteInterface {

	public abstract void clearDispensedItemChute();

	public abstract ArrayList<DispensibleItem> getDispensedItems();

	public abstract void addItemToChute(DispensibleItem itemToDispense);

}
