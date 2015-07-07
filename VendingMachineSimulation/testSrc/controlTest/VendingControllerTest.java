package controlTest;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.DispensibleItem;
import model.UserAccountTeller;
import model.VendingSlotInterface;
import modelTest.MockDispensedItemChute;
import modelTest.MockUserBalance;
import modelTest.MockVendingSlot;
import view.VendingWindow;
import view.VendingWindowInterface;
import viewTest.MockVendingWindow;
import control.ShowInsertCoinTimer;
import control.VendingController;
import control.VendingControllerInterface;

public class VendingControllerTest extends TestCase {

	public void testImplementsVendingControllerInterface() throws Exception {
		assertEquals(1, VendingController.class.getInterfaces().length);
		assertSame(VendingControllerInterface.class, VendingController.class.getInterfaces()[0]);
	}

	public void testGetters() throws Exception {
		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		ArrayList<VendingSlotInterface> vendingSlotCollection = new ArrayList<VendingSlotInterface>();
		UserAccountTeller userAccountTeller = new UserAccountTeller(new MockUserBalance(),
				new MockChangeManager());
		VendingWindowInterface vendingWindow = new VendingWindow();
		VendingController vendingController = new VendingController(vendingSlotCollection,
				dispensedItemChute, userAccountTeller, vendingWindow);

		assertSame(vendingSlotCollection, vendingController.getVendingSlotCollection());
		assertSame(dispensedItemChute, vendingController.getDispensedItemChute());
		assertSame(userAccountTeller, vendingController.getUserAccountTeller());
		assertSame(vendingWindow, vendingController.getVendingWindow());
		assertSame(ShowInsertCoinTimer.class, vendingController.getTimer().getClass());
		int expectedDelayForTimer = 1500;
		assertEquals(expectedDelayForTimer, vendingController.getTimer().getDelay());
	}

	public void testVendProduct_VendsFromSlotASuccessfully() throws Exception {
		ArrayList<VendingSlotInterface> vendingSlots = new ArrayList<VendingSlotInterface>();
		MockVendingSlot vendingSlotA = new MockVendingSlot();
		vendingSlotA.setProductQuantity(2);
		vendingSlotA.setDispensibleItemToReturn(DispensibleItem.COLA);

		vendingSlots.add(vendingSlotA);
		vendingSlots.add(new MockVendingSlot());
		vendingSlots.add(new MockVendingSlot());

		MockUserBalance userBalance = new MockUserBalance();
		String userBalanceString = "1.00";
		userBalance.setBalanceValue(userBalanceString);

		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		VendingController vendingController = new VendingController(vendingSlots,
				dispensedItemChute, new UserAccountTeller(userBalance, changeManager),
				vendingWindow);

		int vendingButtonIndex = 0;
		vendingController.vendProduct(vendingButtonIndex);

		assertTrue(vendingSlotA.getGetProductQuantityWasCalled());
		assertTrue(userBalance.getGetBalanceValueWasCalled());
		assertTrue(vendingSlotA.getSubtractProductQuantityByOneWasCalled());
		assertTrue(userBalance.getSubtractFundsWasCalled());
		assertTrue(dispensedItemChute.getAddItemToChuteWasCalled());
		assertTrue(changeManager.getMakeChangeWasCalled());
		assertTrue(vendingWindow.getShowThankYouMessageWasCalled());
		assertTrue(vendingController.getTimer().getActualTimer().isRunning());
	}

	public void testVendProduct_VendsFromSlotBSuccessfully() throws Exception {
		ArrayList<VendingSlotInterface> vendingSlots = new ArrayList<VendingSlotInterface>();
		MockVendingSlot vendingSlotB = new MockVendingSlot();
		vendingSlotB.setProductQuantity(2);
		vendingSlotB.setDispensibleItemToReturn(DispensibleItem.CHIPS);

		vendingSlots.add(new MockVendingSlot());
		vendingSlots.add(vendingSlotB);
		vendingSlots.add(new MockVendingSlot());

		MockUserBalance userBalance = new MockUserBalance();
		String userBalanceString = "1.00";
		userBalance.setBalanceValue(userBalanceString);

		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		VendingController vendingController = new VendingController(vendingSlots,
				dispensedItemChute, new UserAccountTeller(userBalance, changeManager),
				vendingWindow);

		int vendingButtonIndex = 1;
		vendingController.vendProduct(vendingButtonIndex);

		assertTrue(vendingSlotB.getGetProductQuantityWasCalled());
		assertTrue(userBalance.getGetBalanceValueWasCalled());
		assertTrue(vendingSlotB.getSubtractProductQuantityByOneWasCalled());
		assertTrue(userBalance.getSubtractFundsWasCalled());
		assertTrue(dispensedItemChute.getAddItemToChuteWasCalled());
		assertTrue(changeManager.getMakeChangeWasCalled());
		assertTrue(vendingWindow.getShowThankYouMessageWasCalled());
		assertTrue(vendingController.getTimer().getActualTimer().isRunning());
	}

	public void testVendProduct_VendsFromSlotCSuccessfully() throws Exception {
		ArrayList<VendingSlotInterface> vendingSlotList = new ArrayList<VendingSlotInterface>();
		MockVendingSlot vendingSlotC = new MockVendingSlot();
		vendingSlotC.setProductQuantity(2);
		vendingSlotC.setDispensibleItemToReturn(DispensibleItem.CANDY);
		vendingSlotList.add(new MockVendingSlot());
		vendingSlotList.add(new MockVendingSlot());
		vendingSlotList.add(vendingSlotC);

		MockUserBalance userBalance = new MockUserBalance();
		String userBalanceString = "1.00";
		userBalance.setBalanceValue(userBalanceString);

		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();

		VendingController vendingController = new VendingController(vendingSlotList,
				dispensedItemChute, new UserAccountTeller(userBalance, changeManager),
				vendingWindow);

		int vendingButtonIndex = 2;
		vendingController.vendProduct(vendingButtonIndex);

		assertTrue(vendingSlotC.getGetProductQuantityWasCalled());
		assertTrue(userBalance.getGetBalanceValueWasCalled());
		assertTrue(vendingSlotC.getSubtractProductQuantityByOneWasCalled());
		assertTrue(userBalance.getSubtractFundsWasCalled());
		assertTrue(dispensedItemChute.getAddItemToChuteWasCalled());
		assertTrue(changeManager.getMakeChangeWasCalled());
		assertTrue(vendingWindow.getShowThankYouMessageWasCalled());
		assertTrue(vendingController.getTimer().getActualTimer().isRunning());
	}

	public void testVendProduct_UnsuccessfulDueToZeroQuantity() throws Exception {
		ArrayList<VendingSlotInterface> vendingSlots = new ArrayList<VendingSlotInterface>();
		MockVendingSlot vendingSlotA = new MockVendingSlot();
		vendingSlotA.setProductQuantity(0);
		vendingSlotA.setDispensibleItemToReturn(DispensibleItem.COLA);
		vendingSlots.add(vendingSlotA);

		MockUserBalance userBalance = new MockUserBalance();
		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		VendingController vendingController = new VendingController(vendingSlots,
				dispensedItemChute, new UserAccountTeller(userBalance, changeManager),
				vendingWindow);
		int vendingButtonIndex = 0;
		vendingController.vendProduct(vendingButtonIndex);

		assertTrue(vendingSlotA.getGetProductQuantityWasCalled());
		assertTrue(vendingWindow.getShowSoldOutMessageWasCalled());
		assertTrue(vendingController.getTimer().getActualTimer().isRunning());
		assertFalse(userBalance.getGetBalanceValueWasCalled());
		assertFalse(vendingSlotA.getSubtractProductQuantityByOneWasCalled());
		assertFalse(userBalance.getSubtractFundsWasCalled());
		assertFalse(dispensedItemChute.getAddItemToChuteWasCalled());
		assertFalse(changeManager.getMakeChangeWasCalled());
	}

	public void testVendProduct_UnsuccessfulDueToInsufficientBalance() throws Exception {
		ArrayList<VendingSlotInterface> vendingSlots = new ArrayList<VendingSlotInterface>();
		MockVendingSlot vendingSlotC = new MockVendingSlot();
		vendingSlotC.setProductQuantity(2);
		vendingSlotC.setDispensibleItemToReturn(DispensibleItem.CANDY);
		vendingSlots.add(new MockVendingSlot());
		vendingSlots.add(new MockVendingSlot());
		vendingSlots.add(vendingSlotC);

		MockUserBalance userBalance = new MockUserBalance();
		userBalance.setBalanceValue(".10");

		MockDispensedItemChute dispensedItemChute = new MockDispensedItemChute();
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		VendingController vendingController = new VendingController(vendingSlots,
				dispensedItemChute, new UserAccountTeller(userBalance, changeManager),
				vendingWindow);
		int vendingButtonIndex = 2;
		vendingController.vendProduct(vendingButtonIndex);

		assertTrue(vendingSlotC.getGetProductQuantityWasCalled());
		assertTrue(userBalance.getGetBalanceValueWasCalled());
		assertTrue(vendingWindow.getShowPriceMessageWasCalled());
		assertTrue(vendingController.getTimer().getActualTimer().isRunning());
		assertFalse(vendingSlotC.getSubtractProductQuantityByOneWasCalled());
		assertFalse(userBalance.getSubtractFundsWasCalled());
		assertFalse(dispensedItemChute.getAddItemToChuteWasCalled());
		assertFalse(changeManager.getMakeChangeWasCalled());
	}
}
