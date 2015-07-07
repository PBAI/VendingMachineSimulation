package modelTest;

import junit.framework.TestCase;
import model.DispensibleItem;
import model.NullVendingSlot;
import model.VendingSlotInterface;

public class NullVendingSlotTest extends TestCase {

	public void testImplementsInterface() throws Exception {
		assertEquals(1, NullVendingSlot.class.getInterfaces().length);
		assertEquals(VendingSlotInterface.class, NullVendingSlot.class.getInterfaces()[0]);
	}

	public void testGetDispensibleItemReturnsNullDispensibleItemAndZeroQuantity() throws Exception {
		DispensibleItem expectedItem = DispensibleItem.NULL;
		int expectedQuantity = 0;
		NullVendingSlot slot = new NullVendingSlot(expectedItem, expectedQuantity);
		assertEquals(DispensibleItem.NULL, slot.getDispensibleItem());
		assertEquals(expectedQuantity, slot.getProductQuantity());
	}

}
