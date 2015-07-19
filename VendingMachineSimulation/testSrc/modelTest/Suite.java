package modelTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ChangeValueTest.class);
		suite.addTestSuite(CoinReturnTrayTest.class);
		suite.addTestSuite(DispensedItemChuteTest.class);
		suite.addTestSuite(DispensibleItemTest.class);
		suite.addTestSuite(InsertedCoinPieceTest.class);
		suite.addTestSuite(ProductQuantitiesTest.class);
		suite.addTestSuite(UserAccountTellerTest.class);
		suite.addTestSuite(UserBalanceTest.class);
		suite.addTestSuite(ValidCoinTest.class);
		suite.addTestSuite(VendingSlotTest.class);
		return suite;
	}

}
