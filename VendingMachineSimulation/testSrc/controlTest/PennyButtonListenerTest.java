package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.PennyButtonListener;

public class PennyButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, PennyButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, PennyButtonListener.class.getInterfaces()[0]);
	}

	public void testGetCoinInsertionManager() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		PennyButtonListener listener = new PennyButtonListener(coinInsertionManager);
		assertSame(coinInsertionManager, listener.getCoinInsertionManager());
	}

	public void testGetPennyInsertedCoinPiece() throws Exception {
		PennyButtonListener listener = new PennyButtonListener(new MockCoinInsertionManager());
		assertSame(InsertedCoinPiece.PENNY, listener.getInsertedCoinPiece());
	}

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		PennyButtonListener listener = new PennyButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
