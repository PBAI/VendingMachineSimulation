package control;

import model.InsertedCoinPiece;

public interface CoinInsertionManagerInterface {

	public abstract void returnCoin(InsertedCoinPiece coinToReturn);

	public abstract void addInsertedCoinValueToUserBalanceIfCoinIsValid(InsertedCoinPiece insertedCoin);

}
