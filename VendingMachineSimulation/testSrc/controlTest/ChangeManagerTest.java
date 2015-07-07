package controlTest;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import model.UserBalance;
import modelTest.MockChangeValue;
import modelTest.MockCoinReturnTray;
import modelTest.MockUserBalance;
import viewTest.MockVendingWindow;
import control.ChangeManager;
import control.ChangeManagerInterface;

public class ChangeManagerTest extends TestCase {

	public void testImplementsChangeManagerInterface() throws Exception {
		assertEquals(1, ChangeManager.class.getInterfaces().length);
		assertSame(ChangeManagerInterface.class, ChangeManager.class.getInterfaces()[0]);
	}

	public void testGetUserBalance() throws Exception {
		MockUserBalance userBalance = new MockUserBalance();
		ChangeManager changeManager = new ChangeManager(userBalance, new MockCoinReturnTray(),
				new MockVendingWindow(), new MockChangeValue());
		assertSame(userBalance, changeManager.getUserBalance());
	}

	public void testGetCoinReturnTray() throws Exception {
		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		ChangeManagerInterface changeManager = new ChangeManager(new MockUserBalance(),
				coinReturnTray, new MockVendingWindow(), new MockChangeValue());
		assertSame(coinReturnTray, changeManager.getCoinReturnTray());
	}

	public void testGetVendingWindow() throws Exception {
		MockVendingWindow vendingWindow = new MockVendingWindow();
		ChangeManagerInterface changeManager = new ChangeManager(new MockUserBalance(),
				new MockCoinReturnTray(), vendingWindow, new MockChangeValue());
		assertSame(vendingWindow, changeManager.getVendingWindow());
	}

	public void testGetChangeValue() throws Exception {
		MockChangeValue changeValue = new MockChangeValue();
		ChangeManager changeManager = new ChangeManager(new MockUserBalance(),
				new MockCoinReturnTray(), new MockVendingWindow(), changeValue);
		assertSame(changeValue, changeManager.getChangeValue());
	}

	public void testMakeChange_QuartersOnlyBalance() throws Exception {
		UserBalance userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		assertEquals(1.25, userBalance.getBalanceValue());

		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);

		MockVendingWindow vendingWindow = new MockVendingWindow();
		MockChangeValue changeValue = new MockChangeValue();
		ChangeManagerInterface changeManager = new ChangeManager(userBalance, coinReturnTray,
				vendingWindow, changeValue);

		changeManager.makeChange();
		assertEquals(0d, userBalance.getBalanceValue());
		assertEquals(5, coinReturnTray.getNumberOfTimesAddInsertedCoinToReturnTrayWasCalled());
		assertEquals(5, vendingWindow.getNumberOfTimesShowReturnedQuarterAmountWasCalled());
		assertEquals(5, vendingWindow.getNumberOfTimesShowUpdatedChangeDisplayWasCalled());
		assertEquals(5, changeValue.getNumberOfTimesAddToTotalWasCalled());
		assertEquals(5, changeValue.getNumberOfTimesGetTotalAsFormattedStringWasCalled());
		assertTrue(vendingWindow.getShowUpdatedUserBalanceWasCalled());
	}

	public void testMakeChange_DimesOnlyBalance() throws Exception {
		UserBalance userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.DIME);
		userBalance.addFunds(InsertedCoinPiece.DIME);
		assertEquals(.20, userBalance.getBalanceValue());

		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.DIME);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.DIME);

		MockVendingWindow vendingWindow = new MockVendingWindow();
		MockChangeValue changeValue = new MockChangeValue();
		ChangeManagerInterface changeManager = new ChangeManager(userBalance, coinReturnTray,
				vendingWindow, changeValue);

		changeManager.makeChange();
		assertEquals(0d, userBalance.getBalanceValue());
		assertEquals(2, coinReturnTray.getNumberOfTimesAddInsertedCoinToReturnTrayWasCalled());
		assertEquals(2, vendingWindow.getNumberOfTimesShowReturnedDimeAmountWasCalled());
		assertEquals(2, vendingWindow.getNumberOfTimesShowUpdatedChangeDisplayWasCalled());
		assertEquals(2, changeValue.getNumberOfTimesAddToTotalWasCalled());
		assertEquals(2, changeValue.getNumberOfTimesGetTotalAsFormattedStringWasCalled());
		assertTrue(vendingWindow.getShowUpdatedUserBalanceWasCalled());
	}

	public void testMakeChange_NickelsOnlyBalance() throws Exception {
		UserBalance userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.NICKEL);
		assertEquals(.05, userBalance.getBalanceValue());

		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.NICKEL);

		MockVendingWindow vendingWindow = new MockVendingWindow();
		MockChangeValue changeValue = new MockChangeValue();
		ChangeManagerInterface changeManager = new ChangeManager(userBalance, coinReturnTray,
				vendingWindow, changeValue);

		changeManager.makeChange();
		assertEquals(0d, userBalance.getBalanceValue());
		assertEquals(1, coinReturnTray.getNumberOfTimesAddInsertedCoinToReturnTrayWasCalled());
		assertEquals(1, vendingWindow.getNumberOfTimesShowReturnedNickelAmountWasCalled());
		assertEquals(1, vendingWindow.getNumberOfTimesShowUpdatedChangeDisplayWasCalled());
		assertEquals(1, changeValue.getNumberOfTimesAddToTotalWasCalled());
		assertEquals(1, changeValue.getNumberOfTimesGetTotalAsFormattedStringWasCalled());
		assertTrue(vendingWindow.getShowUpdatedUserBalanceWasCalled());
	}

	public void testMakeChange_MixedChangeBalance() throws Exception {
		UserBalance userBalance = new UserBalance();
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.QUARTER);
		userBalance.addFunds(InsertedCoinPiece.DIME);
		userBalance.addFunds(InsertedCoinPiece.NICKEL);
		assertEquals(.65, userBalance.getBalanceValue());

		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.DIME);
		coinReturnTray.addToQuartersInTray(InsertedCoinPiece.NICKEL);

		MockVendingWindow vendingWindow = new MockVendingWindow();
		MockChangeValue changeValue = new MockChangeValue();
		ChangeManagerInterface changeManager = new ChangeManager(userBalance, coinReturnTray,
				vendingWindow, changeValue);
		changeManager.makeChange();
		assertEquals(0d, userBalance.getBalanceValue());
		assertEquals(4, coinReturnTray.getNumberOfTimesAddInsertedCoinToReturnTrayWasCalled());
		assertEquals(2, vendingWindow.getNumberOfTimesShowReturnedQuarterAmountWasCalled());
		assertEquals(1, vendingWindow.getNumberOfTimesShowReturnedDimeAmountWasCalled());
		assertEquals(1, vendingWindow.getNumberOfTimesShowReturnedNickelAmountWasCalled());
		assertEquals(4, vendingWindow.getNumberOfTimesShowUpdatedChangeDisplayWasCalled());
		assertEquals(4, changeValue.getNumberOfTimesAddToTotalWasCalled());
		assertEquals(4, changeValue.getNumberOfTimesGetTotalAsFormattedStringWasCalled());
	}

	public void testClearChangeTotal() throws Exception {
		MockChangeValue changeValue = new MockChangeValue();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		ChangeManagerInterface changeManager = new ChangeManager(new MockUserBalance(),
				new MockCoinReturnTray(), vendingWindow, changeValue);
		changeManager.clearChangeValueTotal();

		assertTrue(changeValue.getClearTotalWasCalled());
		assertTrue(changeValue.getGetTotalAsFormatedStringWasCalled());
		assertTrue(vendingWindow.getShowUpdatedChangeDisplayWasCalled());
	}
}
