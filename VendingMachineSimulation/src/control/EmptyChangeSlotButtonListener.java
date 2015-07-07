package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoinReturnTrayInterface;
import view.VendingWindowInterface;

public class EmptyChangeSlotButtonListener implements ActionListener {

	private final ChangeManagerInterface changeManager;

	public EmptyChangeSlotButtonListener(ChangeManagerInterface changeManager) {
		this.changeManager = changeManager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.changeManager.clearChangeValueTotal();
		CoinReturnTrayInterface coinReturnTray = this.changeManager.getCoinReturnTray();
		coinReturnTray.emptyReturnTray();
		VendingWindowInterface vendingWindow = this.changeManager.getVendingWindow();

		vendingWindow.showReturnedSlugAmount(coinReturnTray.getSlugsInTray().size());
		vendingWindow.showReturnedQuarterAmount(coinReturnTray.getQuartersInTray().size());
		vendingWindow.showReturnedDimeAmount(coinReturnTray.getDimesInTray().size());
		vendingWindow.showReturnedNickelAmount(coinReturnTray.getNickelsInTray().size());
		vendingWindow.showReturnedPennyAmount(coinReturnTray.getPenniesInTray().size());
	}

	public ChangeManagerInterface getChangeManager() {
		return this.changeManager;
	}
}
