package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.SlugButtonListener;

public class SlugButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, SlugButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, SlugButtonListener.class.getInterfaces()[0]);
	}

	public void testGetCoinInsertionManager() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		SlugButtonListener listener = new SlugButtonListener(coinInsertionManager);
		assertSame(coinInsertionManager, listener.getCoinInsertionManager());
	}

	public void testGetSlugInsertedCoinPiece() throws Exception {
		SlugButtonListener listener = new SlugButtonListener(new MockCoinInsertionManager());
		assertSame(InsertedCoinPiece.SLUG, listener.getInsertedCoinPiece());
	}

	public void testActionPerformed() throws Exception {
		MockCoinInsertionManager coinInsertionManager = new MockCoinInsertionManager();
		SlugButtonListener listener = new SlugButtonListener(coinInsertionManager);
		JButton jButton = new JButton();
		listener.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(coinInsertionManager
				.getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled());
	}
}
