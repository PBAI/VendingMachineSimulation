package modelTest;

import junit.framework.TestCase;
import model.ValidCoin;

public class ValidCoinTest extends TestCase {

	public void testDiameterInMillimetersReturnsCorrectDiameterForConstant() throws Exception {
		assertEquals(21.21, ValidCoin.NICKEL.diameterInMillimeters());
		assertEquals(17.9, ValidCoin.DIME.diameterInMillimeters());
		assertEquals(24.26, ValidCoin.QUARTER.diameterInMillimeters());
	}

	public void testWeightInGramsReturnsCorrectWeightForConstant() throws Exception {
		assertEquals(5d, ValidCoin.NICKEL.weightInGrams());
		assertEquals(2.268, ValidCoin.DIME.weightInGrams());
		assertEquals(5.67, ValidCoin.QUARTER.weightInGrams());
	}

	public void testValueInCentsReturnsCorrectValueForConstant() throws Exception {
		assertEquals(.05, ValidCoin.NICKEL.valueInCents());
		assertEquals(.10, ValidCoin.DIME.valueInCents());
		assertEquals(.25, ValidCoin.QUARTER.valueInCents());
	}

}
