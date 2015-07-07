package model;

public interface UserBalanceInterface {

	public abstract double getBalanceValue();

	public abstract void subtractFunds(String fundsToSubtractAsNumericString);

	public abstract void addFunds(InsertedCoinPiece coinToExtractValueFrom);

}
