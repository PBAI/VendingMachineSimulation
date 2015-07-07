package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.InsertedCoinPiece;

public class NickelButtonListener implements ActionListener {

	private final CoinInsertionManagerInterface coinInsertionManager;
	private final InsertedCoinPiece nickelInsertedCoinPiece;

	public NickelButtonListener(CoinInsertionManagerInterface coinInsertionManager) {
		this.coinInsertionManager = coinInsertionManager;
		this.nickelInsertedCoinPiece = InsertedCoinPiece.NICKEL;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.coinInsertionManager
				.addInsertedCoinValueToUserBalanceIfCoinIsValid(this.nickelInsertedCoinPiece);
	}

	public CoinInsertionManagerInterface getCoinInsertionManager() {
		return this.coinInsertionManager;
	}

	public InsertedCoinPiece getInsertedCoinPiece() {
		return this.nickelInsertedCoinPiece;
	}
}
