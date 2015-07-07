package controlTest;

import control.CoinValidatorInterface;
import model.InsertedCoinPiece;

public class MockCoinValidator implements CoinValidatorInterface {

	private boolean coinIsValidWasCalled = false;
	private boolean coinValidity = false;

	@Override
	public boolean coinIsValid(InsertedCoinPiece coinToValidate) {
		this.coinIsValidWasCalled = true;
		return this.coinValidity;
	}

	public boolean getCoinIsValidWasCalled() {
		return this.coinIsValidWasCalled;
	}

	public void setCoinValidity(boolean coinValidityToSet) {
		this.coinValidity = coinValidityToSet;
	}

}
