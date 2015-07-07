package modelTest;

import junit.framework.TestCase;
import model.ChangeValue;
import model.ChangeValueInterface;

public class ChangeValueTest extends TestCase {

	public void testImplementsChangeValueInterface() throws Exception {
		assertEquals(1, ChangeValue.class.getInterfaces().length);
		assertSame(ChangeValueInterface.class, ChangeValue.class.getInterfaces()[0]);
	}

	public void testGetTotalIsZeroWhenConstructed() throws Exception {
		ChangeValue changeValue = new ChangeValue();
		assertEquals(0.00, changeValue.getTotal());
	}

	public void testAddToTotal() throws Exception {
		ChangeValue changeValue = new ChangeValue();
		double amountToAdd = 5.65;
		changeValue.addToTotal(amountToAdd);
		assertEquals(amountToAdd, changeValue.getTotal());

		double amountToAdd2 = .25;
		changeValue.addToTotal(amountToAdd2);
		double expectedTotal = 5.90;
		assertEquals(expectedTotal, changeValue.getTotal());
	}

	public void testClearTotal() throws Exception {
		ChangeValue changeValue = new ChangeValue();
		double amountToAdd = 2.00;
		changeValue.addToTotal(amountToAdd);
		assertEquals(amountToAdd, changeValue.getTotal());

		changeValue.clearTotal();
		double expectedTotal = 0.00;
		assertEquals(expectedTotal, changeValue.getTotal());
	}

	public void testGetTotalAsString() throws Exception {
		ChangeValueInterface changeValue = new ChangeValue();
		assertEquals("0.00", changeValue.getTotalAsFormattedString());
	}
}
