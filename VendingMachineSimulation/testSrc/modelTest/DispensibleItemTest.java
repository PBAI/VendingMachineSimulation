package modelTest;

import junit.framework.TestCase;
import model.DispensibleItem;

public class DispensibleItemTest extends TestCase {

	public void testPriceOfItemReturnsCorrectPriceForItem() throws Exception {
		assertEquals(1.00, DispensibleItem.COLA.priceOfItem());
		assertEquals(.50, DispensibleItem.CHIPS.priceOfItem());
		assertEquals(.65, DispensibleItem.CANDY.priceOfItem());
		assertEquals(0.00, DispensibleItem.NULL.priceOfItem());
	}

	public void testNameOfItemReturnsCorrectItemName() throws Exception {
		assertEquals("cola", DispensibleItem.COLA.nameOfItem());
		assertEquals("chips", DispensibleItem.CHIPS.nameOfItem());
		assertEquals("candy", DispensibleItem.CANDY.nameOfItem());
		assertEquals("nothing", DispensibleItem.NULL.nameOfItem());
	}

}
