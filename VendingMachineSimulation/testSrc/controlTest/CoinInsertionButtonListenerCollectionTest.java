package controlTest;

import junit.framework.TestCase;
import control.CoinInsertionButtonListenerCollection;
import control.DimeButtonListener;
import control.NickelButtonListener;
import control.PennyButtonListener;
import control.QuarterButtonListener;
import control.SlugButtonListener;

public class CoinInsertionButtonListenerCollectionTest extends TestCase {

	public void testGetters() throws Exception {
		PennyButtonListener pennyButtonListener = new PennyButtonListener(
				new MockCoinInsertionManager());
		NickelButtonListener nickelButtonListener = new NickelButtonListener(
				new MockCoinInsertionManager());
		DimeButtonListener dimeButtonListener = new DimeButtonListener(
				new MockCoinInsertionManager());
		QuarterButtonListener quarterButtonListener = new QuarterButtonListener(
				new MockCoinInsertionManager());
		SlugButtonListener slugButtonListener = new SlugButtonListener(
				new MockCoinInsertionManager());
		CoinInsertionButtonListenerCollection collection = new CoinInsertionButtonListenerCollection(
				pennyButtonListener, nickelButtonListener, dimeButtonListener,
				quarterButtonListener, slugButtonListener);

		assertSame(pennyButtonListener, collection.getPennyButtonListener());
		assertSame(nickelButtonListener, collection.getNickelButtonListener());
		assertSame(dimeButtonListener, collection.getDimeButtonListener());
		assertSame(quarterButtonListener, collection.getQuarterButtonListener());
		assertSame(slugButtonListener, collection.getSlugButtonListener());
	}
}
