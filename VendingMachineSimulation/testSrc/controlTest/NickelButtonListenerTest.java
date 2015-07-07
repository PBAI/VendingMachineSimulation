package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.NickelButtonListener;

public class NickelButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, NickelButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, NickelButtonListener.class.getInterfaces()[0]);
	}

	public void testGetCoinInsertionManager() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		NickelButtonListener listener = new NickelButtonListener(coinInsertionManager);
		assertSame(coinInsertionManager, listener.getCoinInsertionManager());
	}

	public void testGetNickelInsertedCoinPiece() throws Exception {
		NickelButtonListener listener = new NickelButtonListener(new MockCoinInsertionManager());
		assertSame(InsertedCoinPiece.NICKEL, listener.getInsertedCoinPiece());
	}

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		NickelButtonListener listener = new NickelButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
