package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class VendingButtonListener implements ActionListener {

	ArrayList<JButton> vendingButtons;
	VendingControllerInterface vendingController;

	public VendingButtonListener(ArrayList<JButton> vendingButtons,
			VendingControllerInterface vendingController) {
		this.vendingButtons = vendingButtons;
		this.vendingController = vendingController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int noButtonsPressed = -1;
		int vendingButtonIndex = noButtonsPressed;

		for (JButton button : vendingButtons) {
			if (e.getSource() == button) {
				vendingButtonIndex = vendingButtons.indexOf(button);
			}
		}
		this.vendingController.vendProduct(vendingButtonIndex);
	}

	public ArrayList<JButton> getVendingButtons() {
		return this.vendingButtons;
	}

	public VendingControllerInterface getVendingController() {
		return this.vendingController;
	}

}
