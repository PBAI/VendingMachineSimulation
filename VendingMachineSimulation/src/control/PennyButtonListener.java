package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InsertedCoinPiece;

public class PennyButtonListener implements ActionListener {

	private final CoinInsertionManagerInterface coinInsertionManager;
	private final InsertedCoinPiece pennyInsertedCoinPiece;

	public PennyButtonListener(CoinInsertionManagerInterface coinInsertionManager) {
		this.coinInsertionManager = coinInsertionManager;
		this.pennyInsertedCoinPiece = InsertedCoinPiece.PENNY;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.coinInsertionManager
				.addInsertedCoinValueToUserBalanceIfCoinIsValid(this.pennyInsertedCoinPiece);
	}

	public CoinInsertionManagerInterface getCoinInsertionManager() {
		return this.coinInsertionManager;
	}

	public InsertedCoinPiece getInsertedCoinPiece() {
		return this.pennyInsertedCoinPiece;
	}
}
