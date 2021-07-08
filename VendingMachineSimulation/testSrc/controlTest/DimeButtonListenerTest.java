package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.DimeButtonListener;

public class DimeButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, DimeButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, DimeButtonListener.class.getInterfaces()[0]);
	}

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		DimeButtonListener listener = new DimeButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
