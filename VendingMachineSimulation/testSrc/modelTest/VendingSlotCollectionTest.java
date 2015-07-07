package modelTest;

import junit.framework.TestCase;
import model.VendingSlotCollection;

public class VendingSlotCollectionTest extends TestCase {

	public void testGetters() throws Exception {
		MockVendingSlot vendingSlotA = new MockVendingSlot();
		MockVendingSlot vendingSlotB = new MockVendingSlot();
		MockVendingSlot vendingSlotC = new MockVendingSlot();
		VendingSlotCollection vendingSlotCollection = new VendingSlotCollection(vendingSlotA,
				vendingSlotB, vendingSlotC);
		assertSame(vendingSlotA, vendingSlotCollection.getVendingSlotA());
		assertSame(vendingSlotB, vendingSlotCollection.getVendingSlotB());
		assertSame(vendingSlotC, vendingSlotCollection.getVendingSlotC());
	}

}
