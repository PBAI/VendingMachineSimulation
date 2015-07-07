package modelTest;

import junit.framework.TestCase;
import model.DispensibleItem;
import model.VendingSlot;
import model.VendingSlotInterface;

public class VendingSlotTest extends TestCase {

	public void testImplementsVendingSlotInterface() throws Exception {
		assertEquals(1, VendingSlot.class.getInterfaces().length);
		assertSame(VendingSlotInterface.class, VendingSlot.class.getInterfaces()[0]);
	}

	public void testGetDispensibleItem() throws Exception {
		DispensibleItem expectedSlotADispensibleItem = DispensibleItem.COLA;
		VendingSlotInterface slot = new VendingSlot(expectedSlotADispensibleItem, 2);
		assertSame(expectedSlotADispensibleItem, slot.getDispensibleItem());
	}

	public void testGetProductQuantity() throws Exception {
		int productQuantity = 5;
		VendingSlotInterface vendingSlot = new VendingSlot(DispensibleItem.COLA, productQuantity);
		assertSame(productQuantity, vendingSlot.getProductQuantity());

	}

	public void testSubtractProductQuantityByOne() throws Exception {
		int productQuantity = 1;
		VendingSlotInterface vendingSlot = new VendingSlot(DispensibleItem.COLA, productQuantity);
		assertEquals(productQuantity, vendingSlot.getProductQuantity());
		vendingSlot.subtractProductQuantityByOne();
		assertEquals(0, vendingSlot.getProductQuantity());
	}

}
