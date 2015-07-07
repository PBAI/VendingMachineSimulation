package model;

import java.math.BigDecimal;

public class UserBalance implements UserBalanceInterface {

	private BigDecimal balanceValue;

	public UserBalance() {
		this.balanceValue = new BigDecimal("0.00");
	}

	@Override
	public void addFunds(InsertedCoinPiece coinToExtractValueFrom) {
		double fundsToAdd = extractValueFromInsertedCoin(coinToExtractValueFrom);
		BigDecimal fundsToAddAsDecimal = new BigDecimal(Double.toString(fundsToAdd));
		this.balanceValue = this.balanceValue.add(fundsToAddAsDecimal);
	}

	@Override
	public void subtractFunds(String fundsToSubtractAsNumericStringRepresentingValueAsDouble) {
		BigDecimal fundsToSubtractAsDecimal = new BigDecimal(
				fundsToSubtractAsNumericStringRepresentingValueAsDouble);
		BigDecimal subtractedValue = this.balanceValue.subtract(fundsToSubtractAsDecimal);
		this.balanceValue = subtractedValue;
	}

	@Override
	public double getBalanceValue() {
		return this.balanceValue.doubleValue();
	}

	private double extractValueFromInsertedCoin(InsertedCoinPiece coinToExtractValueFrom) {
		double fundsToAdd = 0;
		for (ValidCoin coin : ValidCoin.values()) {
			if (coinToExtractValueFrom.diameterInMillimeters() == coin.diameterInMillimeters()) {
				fundsToAdd = coin.valueInCents();
			}
		}
		return fundsToAdd;
	}
}
