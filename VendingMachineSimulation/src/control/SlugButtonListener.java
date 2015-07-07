package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InsertedCoinPiece;

public class SlugButtonListener implements ActionListener {

	private final CoinInsertionManagerInterface coinInsertionManager;
	private final InsertedCoinPiece slugInsertedCoinPiece;

	public SlugButtonListener(CoinInsertionManagerInterface coinInsertionManager) {
		this.coinInsertionManager = coinInsertionManager;
		this.slugInsertedCoinPiece = InsertedCoinPiece.SLUG;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.coinInsertionManager
				.addInsertedCoinValueToUserBalanceIfCoinIsValid(this.slugInsertedCoinPiece);
	}

	public CoinInsertionManagerInterface getCoinInsertionManager() {
		return this.coinInsertionManager;
	}

	public InsertedCoinPiece getInsertedCoinPiece() {
		return this.slugInsertedCoinPiece;
	}
}
