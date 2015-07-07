package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InsertedCoinPiece;

public class DimeButtonListener implements ActionListener {

	private final CoinInsertionManagerInterface coinInsertionManager;
	private final InsertedCoinPiece dimeInsertedCoinPiece;

	public DimeButtonListener(CoinInsertionManagerInterface coinInsertionManager) {
		this.coinInsertionManager = coinInsertionManager;
		this.dimeInsertedCoinPiece = InsertedCoinPiece.DIME;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.coinInsertionManager
				.addInsertedCoinValueToUserBalanceIfCoinIsValid(this.dimeInsertedCoinPiece);
	}

	public CoinInsertionManagerInterface getCoinInsertionManager() {
		return this.coinInsertionManager;
	}

	public InsertedCoinPiece getInsertedCoinPiece() {
		return this.dimeInsertedCoinPiece;
	}
}
