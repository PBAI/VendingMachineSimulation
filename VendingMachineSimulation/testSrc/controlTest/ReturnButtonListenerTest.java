package controlTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import junit.framework.TestCase;
import control.ReturnButtonListener;

public class ReturnButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, ReturnButtonListener.class.getInterfaces().length);
		assertSame(ActionListener.class, ReturnButtonListener.class.getInterfaces()[0]);
	}

	public void testGetChangeManager() throws Exception {
		MockChangeManager changeManager = new MockChangeManager();
		ReturnButtonListener returnButtonListener = new ReturnButtonListener(changeManager);
		assertSame(changeManager, returnButtonListener.getChangeManager());
	}

	public void testActionPerformed() throws Exception {
		MockChangeManager changeManager = new MockChangeManager();
		ReturnButtonListener returnButtonListener = new ReturnButtonListener(changeManager);
		JButton jButton = new JButton();
		returnButtonListener
				.actionPerformed(new ActionEvent(jButton, 1, jButton.getActionCommand()));
		assertTrue(changeManager.getMakeChangeWasCalled());
	}

}
