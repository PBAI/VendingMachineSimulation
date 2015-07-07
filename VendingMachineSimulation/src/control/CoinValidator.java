package control;

import model.InsertedCoinPiece;
import model.ValidCoin;

public class CoinValidator implements CoinValidatorInterface {

	@Override
	public boolean coinIsValid(InsertedCoinPiece coinToValidate) {
		for (ValidCoin coin : ValidCoin.values()) {
			if ((coin.diameterInMillimeters() == coinToValidate.diameterInMillimeters())
					&& (coin.weightInGrams() == coinToValidate.weightInGrams())) {
				return true;
			}
		}
		return false;
	}
}
