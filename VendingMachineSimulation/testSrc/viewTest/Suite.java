package viewTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(CoinInputButtonPanelTest.class);
		suite.addTestSuite(CoinReturnDisplayPanelTest.class);
		suite.addTestSuite(EmptyChangeSlotButtonPanelTest.class);
		suite.addTestSuite(ReturnPanelTest.class);
		suite.addTestSuite(UserBalanceDisplayPanelTest.class);
		suite.addTestSuite(UserCommunicationDisplayPanelTest.class);
		suite.addTestSuite(VendingWindowTest.class);
		return suite;
	}

}
