package modelTest;

import java.math.BigDecimal;

import model.InsertedCoinPiece;
import model.UserBalanceInterface;

public class MockUserBalance implements UserBalanceInterface {

	private BigDecimal balanceValue;
	private boolean subtractFundsWasCalled;
	private boolean addFundsWasCalled = false;
	private boolean getBalanceValueWasCalled;

	public MockUserBalance() {
		this.balanceValue = new BigDecimal("0.0");
		this.getBalanceValueWasCalled = false;
		this.subtractFundsWasCalled = false;
	}

	@Override
	public double getBalanceValue() {
		this.getBalanceValueWasCalled = true;
		return this.balanceValue.doubleValue();
	}

	@Override
	public void subtractFunds(String fundsToSubtractAsNumericString) {
		this.subtractFundsWasCalled = true;
	}

	@Override
	public void addFunds(InsertedCoinPiece coinToExtractValueFrom) {
		this.addFundsWasCalled = true;
	}

	public boolean getSubtractFundsWasCalled() {
		return this.subtractFundsWasCalled;
	}

	public boolean getAddFundsWasCalled() {
		return this.addFundsWasCalled;
	}

	public void setBalanceValue(String stringRepresentingBalanceAsDouble) {
		this.balanceValue = new BigDecimal(stringRepresentingBalanceAsDouble);
	}

	public boolean getGetBalanceValueWasCalled() {
		return this.getBalanceValueWasCalled;
	}
}
