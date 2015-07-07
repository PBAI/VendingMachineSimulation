package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InsertedCoinPiece;

public class QuarterButtonListener implements ActionListener {

	private final CoinInsertionManagerInterface coinInsertionManager;
	private final InsertedCoinPiece quarterInsertedCoinPiece;

	public QuarterButtonListener(CoinInsertionManagerInterface coinInsertionManager) {
		this.coinInsertionManager = coinInsertionManager;
		this.quarterInsertedCoinPiece = InsertedCoinPiece.QUARTER;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.coinInsertionManager
				.addInsertedCoinValueToUserBalanceIfCoinIsValid(this.quarterInsertedCoinPiece);
	}

	public CoinInsertionManagerInterface getCoinInsertionManager() {
		return this.coinInsertionManager;
	}

	public InsertedCoinPiece getInsertedCoinPiece() {
		return this.quarterInsertedCoinPiece;
	}
}
