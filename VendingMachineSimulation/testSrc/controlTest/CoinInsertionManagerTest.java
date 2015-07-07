package controlTest;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import modelTest.MockCoinReturnTray;
import modelTest.MockUserBalance;
import viewTest.MockVendingWindow;
import control.CoinInsertionManager;
import control.CoinInsertionManagerInterface;

public class CoinInsertionManagerTest extends TestCase {

	public void testImplementsCoinInsertionManagerInterface() throws Exception {
		assertEquals(1, CoinInsertionManager.class.getInterfaces().length);
		assertSame(CoinInsertionManagerInterface.class,
				CoinInsertionManager.class.getInterfaces()[0]);
	}

	public void testGetCoinValidator() throws Exception {
		MockCoinValidator coinValidator = new MockCoinValidator();
		CoinInsertionManager coinManager = new CoinInsertionManager(coinValidator,
				new MockUserBalance(), new MockCoinReturnTray(), new MockVendingWindow());
		assertSame(coinValidator, coinManager.getCoinValidator());
	}

	public void testGetUserBalance() throws Exception {
		MockUserBalance userBalance = new MockUserBalance();
		CoinInsertionManager coinManager = new CoinInsertionManager(new MockCoinValidator(),
				userBalance, new MockCoinReturnTray(), new MockVendingWindow());
		assertSame(userBalance, coinManager.getUserBalance());
	}

	public void testGetCoinReturnTray() throws Exception {
		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		CoinInsertionManager coinManager = new CoinInsertionManager(new MockCoinValidator(),
				new MockUserBalance(), coinReturnTray, new MockVendingWindow());
		assertSame(coinReturnTray, coinManager.getCoinReturnTray());
	}

	public void testGetVendingWindow() throws Exception {
		MockVendingWindow vendingWindow = new MockVendingWindow();
		CoinInsertionManager coinInsertionManager = new CoinInsertionManager(
				new MockCoinValidator(), new MockUserBalance(), new MockCoinReturnTray(),
				vendingWindow);
		assertSame(vendingWindow, coinInsertionManager.getVendingWindow());
	}

	public void testAddInsertedCoinValueToUserBalanceIfCoinIsValid_ValidInsertedCoin()
			throws Exception {
		MockCoinValidator coinValidator = new MockCoinValidator();
		coinValidator.setCoinValidity(true);
		MockUserBalance userBalance = new MockUserBalance();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		CoinInsertionManagerInterface coinManager = new CoinInsertionManager(coinValidator,
				userBalance, new MockCoinReturnTray(), vendingWindow);
		coinManager.addInsertedCoinValueToUserBalanceIfCoinIsValid(InsertedCoinPiece.NICKEL);
		assertTrue(userBalance.getAddFundsWasCalled());
		assertTrue(vendingWindow.getShowUpdatedUserBalanceWasCalled());
	}

	public void testAddInsertedCoinValueToUserBalanceIfCoinIsValid_InvalidInsertedCoin()
			throws Exception {
		MockCoinValidator coinValidator = new MockCoinValidator();
		coinValidator.setCoinValidity(false);
		MockUserBalance userBalance = new MockUserBalance();
		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		CoinInsertionManagerInterface coinManager = new CoinInsertionManager(coinValidator,
				userBalance, coinReturnTray, new MockVendingWindow());
		coinManager.addInsertedCoinValueToUserBalanceIfCoinIsValid(InsertedCoinPiece.QUARTER);
		assertFalse(userBalance.getAddFundsWasCalled());
		assertTrue(coinReturnTray.getAddInsertedCoinToReturnTrayWasCalled());
	}

	public void testRetunCoin_AddsCoinToRetunTrayAndUpdatesTrayAmountDisplays() throws Exception {
		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		CoinInsertionManagerInterface coinManager = new CoinInsertionManager(
				new MockCoinValidator(), new MockUserBalance(), coinReturnTray, vendingWindow);
		coinManager.returnCoin(InsertedCoinPiece.NICKEL);

		assertTrue(coinReturnTray.getAddInsertedCoinToReturnTrayWasCalled());
		assertTrue(coinReturnTray.getGetSlugsInTrayWasCalled());
		assertTrue(coinReturnTray.getGetQuartersInTrayWasCalled());
		assertTrue(coinReturnTray.getGetDimesInTrayWasCalled());
		assertTrue(coinReturnTray.getGetNickelsInTrayWasCalled());
		assertTrue(coinReturnTray.getGetPenniesInTrayWasCalled());

		assertTrue(vendingWindow.getShowReturnedSlugAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedQuarterAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedDimeAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedNickelAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedPennyAmountWasCalled());
	}

}
