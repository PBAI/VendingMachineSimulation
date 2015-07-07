package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import control.InsertCoinDisplayUpdateActionListener;
import junit.framework.TestCase;
import viewTest.MockVendingWindow;

public class InsertCoinDisplayUpdateActionListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, InsertCoinDisplayUpdateActionListener.class.getInterfaces().length);
		assertSame(ActionListener.class,
				InsertCoinDisplayUpdateActionListener.class.getInterfaces()[0]);
	}

	public void testGetVendingWindow() throws Exception {
		MockVendingWindow vendingWindow = new MockVendingWindow();
		InsertCoinDisplayUpdateActionListener listener = new InsertCoinDisplayUpdateActionListener(
				vendingWindow);
		assertSame(vendingWindow, listener.getVendingWindow());
	}

	public void testActionPerformedShowsInsertCoinsMessageOnVendingWindow() throws Exception {
		MockVendingWindow vendingWindow = new MockVendingWindow();
		InsertCoinDisplayUpdateActionListener listener = new InsertCoinDisplayUpdateActionListener(
				vendingWindow);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(vendingWindow.getShowInsertCoinsMessageWasCalled());
	}
}
