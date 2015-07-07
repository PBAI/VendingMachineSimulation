package modelTest;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import model.UserBalance;
import model.UserBalanceInterface;

public class UserBalanceTest extends TestCase {

	public void testImplementsUserBalanceInterface() throws Exception {
		assertEquals(1, UserBalance.class.getInterfaces().length);
		assertSame(UserBalanceInterface.class, UserBalance.class.getInterfaces()[0]);
	}

	public void testWhenNewUserBalanceIsConstructedBalanceValueIsInitiallyZero() throws Exception {
		UserBalanceInterface balance = new UserBalance();
		assertEquals(0d, balance.getBalanceValue());
	}

	public void testAddFundsActuallyAddsCorrectFundsToBalanceValue() throws Exception {
		UserBalanceInterface userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		double expectedBalanceValueAsFractionOfADollar = .25;
		assertEquals("Make certain that the conversion to fraction of a dollar is .01!",
				expectedBalanceValueAsFractionOfADollar, userBalance.getBalanceValue());
	}

	public void testSubtractFundsActuallyRemovesCorrectFundsToBalanceValue() throws Exception {
		UserBalanceInterface userBalance = new UserBalance();

		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.DIME);

		double expectedUserBalanceAsFractionOfDollar = .60;
		assertEquals(expectedUserBalanceAsFractionOfDollar, userBalance.getBalanceValue());

		userBalance.subtractFunds(".50");
		double expectedUserBalanceAsFractionOfDollarAfterSubtractingFunds = .10;
		assertEquals(expectedUserBalanceAsFractionOfDollarAfterSubtractingFunds,
				userBalance.getBalanceValue());
	}

	public void testGetBalanceValueReturnsDouble() throws Exception {
		UserBalance userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		assertEquals("You should be returning a double from getBalanceValue()!", .25,
				userBalance.getBalanceValue());
	}
}
