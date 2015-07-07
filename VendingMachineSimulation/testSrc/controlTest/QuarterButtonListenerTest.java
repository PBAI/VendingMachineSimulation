package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.QuarterButtonListener;

public class QuarterButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, QuarterButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, QuarterButtonListener.class.getInterfaces()[0]);
	}

	public void testGetCoinInsertionManager() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		QuarterButtonListener listener = new QuarterButtonListener(coinInsertionManager);
		assertSame(coinInsertionManager, listener.getCoinInsertionManager());
	}

	public void testGetQuarterInsertedCoinPiece() throws Exception {
		QuarterButtonListener listener = new QuarterButtonListener(new MockCoinInsertionManager());
		assertSame(InsertedCoinPiece.QUARTER, listener.getInsertedCoinPiece());
	}

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		QuarterButtonListener listener = new QuarterButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
