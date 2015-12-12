package controlTest;

import junit.framework.TestCase;
import model.InsertedCoinPiece;
import control.CoinValidator;
import control.CoinValidatorInterface;

public class CoinValidatorTest extends TestCase {

	public void testImplementsCoinValidatorInterface() throws Exception {
		assertEquals(1, CoinValidator.class.getInterfaces().length);
		assertEquals(CoinValidatorInterface.class, CoinValidator.class.getInterfaces()[0]);
	}

	public void testCoinIsValidReturnsTrueWhenValidCoinIsInserted() throws Exception {
		CoinValidatorInterface validator = new CoinValidator();
		assertTrue(validator.coinIsValid(InsertedCoinPiece.NICKEL));
	}

	public void testCoinIsValidReturnsFalseWhenInvalidCoinIsInserted() throws Exception {
		CoinValidatorInterface coinValidator = new CoinValidator();
		assertFalse(coinValidator.coinIsValid(InsertedCoinPiece.PENNY));
	}
}
