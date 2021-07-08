package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.PennyButtonListener;

public class PennyButtonListenerTest extends TestCase {

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		PennyButtonListener listener = new PennyButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
