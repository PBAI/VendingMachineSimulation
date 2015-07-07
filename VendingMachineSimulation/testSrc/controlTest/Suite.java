package controlTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ChangeManagerTest.class);
		suite.addTestSuite(CoinInsertionButtonListenerCollectionTest.class);
		suite.addTestSuite(CoinInsertionManagerTest.class);
		suite.addTestSuite(CoinValidatorTest.class);
		suite.addTestSuite(DimeButtonListenerTest.class);
		suite.addTestSuite(EmptyChangeSlotButtonListenerTest.class);
		suite.addTestSuite(InsertCoinDisplayUpdateActionListenerTest.class);
		suite.addTestSuite(NickelButtonListenerTest.class);
		suite.addTestSuite(PennyButtonListenerTest.class);
		suite.addTestSuite(QuarterButtonListenerTest.class);
		suite.addTestSuite(ReturnButtonListenerTest.class);
		suite.addTestSuite(ShowInsertCoinTimerTest.class);
		suite.addTestSuite(SlugButtonListenerTest.class);
		suite.addTestSuite(VendingControllerTest.class);
		return suite;
	}
}
