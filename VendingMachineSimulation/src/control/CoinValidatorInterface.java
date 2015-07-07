package control;

import model.InsertedCoinPiece;

public interface CoinValidatorInterface {

	public abstract boolean coinIsValid(InsertedCoinPiece coinToValidate);

}
