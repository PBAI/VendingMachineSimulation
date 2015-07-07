package controlTest;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import junit.framework.TestCase;
import control.VendingButtonListener;

public class VendingButtonListenerTest extends TestCase {

	public void testImplementsActionListener() throws Exception {
		assertEquals(1, VendingButtonListener.class.getInterfaces().length);
		assertEquals(ActionListener.class, VendingButtonListener.class.getInterfaces()[0]);
	}

	public void testGetters() throws Exception {
		ArrayList<JButton> vendingButtons = new ArrayList<JButton>();
		MockVendingController vendingController = new MockVendingController();

		VendingButtonListener listener = new VendingButtonListener(vendingButtons,
				vendingController);

		assertSame(vendingButtons, listener.getVendingButtons());
		assertSame(vendingController, listener.getVendingController());

	}

	public void testActionPerformedCallsVendProductOnVendingControllerAndPassesButtonIndex()
			throws Exception {
		ArrayList<JButton> allVendingButtons = new ArrayList<JButton>();
		JButton buttonOne = new JButton();
		JButton buttonTwo = new JButton();
		JButton buttonThree = new JButton();

		allVendingButtons.add(buttonOne);
		allVendingButtons.add(buttonTwo);
		allVendingButtons.add(buttonThree);

		MockVendingController vendingController = new MockVendingController();
		VendingButtonListener listener = new VendingButtonListener(allVendingButtons,
				vendingController);

		buttonOne.addActionListener(listener);
		buttonTwo.addActionListener(listener);
		buttonThree.addActionListener(listener);

		buttonTwo.doClick();
		assertEquals(allVendingButtons.indexOf(buttonTwo),
				vendingController.getVendingButtonIndex());
		assertTrue(vendingController.getVendProductWasCalled());
	}
}
