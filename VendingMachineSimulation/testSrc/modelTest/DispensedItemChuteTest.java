package modelTest;

import java.util.ArrayList;

import model.DispensedItemChute;
import model.DispensedItemChuteInterface;
import model.DispensibleItem;
import junit.framework.TestCase;

public class DispensedItemChuteTest extends TestCase {

	public void testImplementsDispensedItemChuteInterface() throws Exception {
		assertEquals(1, DispensedItemChute.class.getInterfaces().length);
		assertSame(DispensedItemChuteInterface.class, DispensedItemChute.class.getInterfaces()[0]);
	}

	public void testGetDispensedItems() throws Exception {
		DispensedItemChuteInterface dispensedItemChute = new DispensedItemChute();
		assertSame(ArrayList.class, dispensedItemChute.getDispensedItems().getClass());
		assertEquals(0, dispensedItemChute.getDispensedItems().size());
	}

	public void testAddItemToChute() throws Exception {
		DispensedItemChuteInterface dispensedItemChute = new DispensedItemChute();
		dispensedItemChute.addItemToChute(DispensibleItem.CANDY);
		assertEquals(1, dispensedItemChute.getDispensedItems().size());
	}

	public void testClearDispensedItemChute() throws Exception {
		DispensedItemChuteInterface dispensedItemChute = new DispensedItemChute();
		dispensedItemChute.addItemToChute(DispensibleItem.CHIPS);
		dispensedItemChute.addItemToChute(DispensibleItem.CANDY);
		dispensedItemChute.addItemToChute(DispensibleItem.COLA);
		assertEquals(3, dispensedItemChute.getDispensedItems().size());

		dispensedItemChute.clearDispensedItemChute();
		assertEquals(0, dispensedItemChute.getDispensedItems().size());
	}
}
