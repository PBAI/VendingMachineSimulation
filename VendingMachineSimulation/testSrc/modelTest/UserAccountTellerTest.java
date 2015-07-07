package modelTest;

import junit.framework.TestCase;
import model.UserAccountTeller;
import controlTest.MockChangeManager;

public class UserAccountTellerTest extends TestCase {

	public void testGetters() throws Exception {
		MockUserBalance userBalance = new MockUserBalance();
		MockChangeManager changeManager = new MockChangeManager();
		UserAccountTeller userAccountTeller = new UserAccountTeller(userBalance, changeManager);
		assertSame(userBalance, userAccountTeller.getUserBalance());
		assertSame(changeManager, userAccountTeller.getChangeManager());
	}

}
