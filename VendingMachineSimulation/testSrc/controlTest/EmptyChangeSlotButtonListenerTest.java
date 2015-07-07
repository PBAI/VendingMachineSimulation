package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import modelTest.MockCoinReturnTray;
import viewTest.MockVendingWindow;
import control.EmptyChangeSlotButtonListener;

public class EmptyChangeSlotButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, EmptyChangeSlotButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, EmptyChangeSlotButtonListener.class.getInterfaces()[0]);
	}

	public void testGetChangeManager() throws Exception {
		MockChangeManager changeManager = new MockChangeManager();
		EmptyChangeSlotButtonListener listener = new EmptyChangeSlotButtonListener(changeManager);
		assertSame(changeManager, listener.getChangeManager());
	}

	public void testActionPerformed() throws Exception {
		MockChangeManager changeManager = new MockChangeManager();
		MockVendingWindow vendingWindow = new MockVendingWindow();
		changeManager.setVendingWindowToReturn(vendingWindow);
		MockCoinReturnTray coinReturnTray = new MockCoinReturnTray();
		changeManager.setCoinReturnTrayToReturn(coinReturnTray);
		EmptyChangeSlotButtonListener listener = new EmptyChangeSlotButtonListener(changeManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(changeManager.getClearChangeValueTotalWasCalled());
		assertTrue(changeManager.getGetCoinReturnTrayWasCalled());
		assertTrue(coinReturnTray.getEmptyReturnTrayWasCalled());
		assertTrue(changeManager.getGetVendingWindowWasCalled());

		assertTrue(vendingWindow.getShowReturnedSlugAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedQuarterAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedDimeAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedNickelAmountWasCalled());
		assertTrue(vendingWindow.getShowReturnedPennyAmountWasCalled());

		assertTrue(coinReturnTray.getGetSlugsInTrayWasCalled());
		assertTrue(coinReturnTray.getGetQuartersInTrayWasCalled());
		assertTrue(coinReturnTray.getGetDimesInTrayWasCalled());
		assertTrue(coinReturnTray.getGetNickelsInTrayWasCalled());
		assertTrue(coinReturnTray.getGetPenniesInTrayWasCalled());
	}

}
