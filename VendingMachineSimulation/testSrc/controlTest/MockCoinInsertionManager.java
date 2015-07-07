package controlTest;

import model.InsertedCoinPiece;
import control.CoinInsertionManagerInterface;

public class MockCoinInsertionManager implements CoinInsertionManagerInterface {

	private boolean returnCoinWasCalled;
	private boolean addInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled;

	public MockCoinInsertionManager() {
		this.returnCoinWasCalled = false;
		this.addInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled = false;
	}

	@Override
	public void returnCoin(InsertedCoinPiece coinToReturn) {
		this.returnCoinWasCalled = true;
	}

	@Override
	public void addInsertedCoinValueToUserBalanceIfCoinIsValid(InsertedCoinPiece insertedCoin) {
		this.addInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled = true;
	}

	public boolean getReturnCoinWasCalled() {
		return this.returnCoinWasCalled;
	}

	public boolean getAddInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled() {
		return this.addInsertedCoinValueToUserBalanceIfCoinIsValidWasCalled;
	}
}
