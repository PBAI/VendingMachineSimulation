package controlTest;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.CoinValidator;
import control.CoinValidatorInterface;

public class CoinValidatorTest extends TestCase {

	public void testCoinIsValidReturnsTrueWhenValidCoinIsInserted() throws Exception {
		CoinValidatorInterface validator = new CoinValidator();
		assertTrue(validator.coinIsValid(InsertedCoinPiece.NICKEL));
	}

	public void testCoinIsValidReturnsFalseWhenInvalidCoinIsInserted() throws Exception {
		CoinValidatorInterface coinValidator = new CoinValidator();
		assertFalse(coinValidator.coinIsValid(InsertedCoinPiece.PENNY));
	}
}
