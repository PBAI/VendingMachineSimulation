package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VendingWindowInterface;

public class InsertCoinDisplayUpdateActionListener implements ActionListener {

	private final VendingWindowInterface vendingWindow;

	public InsertCoinDisplayUpdateActionListener(VendingWindowInterface vendingWindow) {
		this.vendingWindow = vendingWindow;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vendingWindow.showInsertCoinsMessage();
	}

	public VendingWindowInterface getVendingWindow() {
		return this.vendingWindow;
	}

}
