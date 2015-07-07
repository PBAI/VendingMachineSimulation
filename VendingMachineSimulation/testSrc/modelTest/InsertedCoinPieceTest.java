package modelTest;

import model.InsertedCoinPiece;
import junit.framework.TestCase;

public class InsertedCoinPieceTest extends TestCase {

	public void testDiameterInMillimetersReturnsCorrectDiameterForConstant() throws Exception {
		assertEquals(19.05, InsertedCoinPiece.PENNY.diameterInMillimeters());
		assertEquals(21.21, InsertedCoinPiece.NICKEL.diameterInMillimeters());
		assertEquals(17.9, InsertedCoinPiece.DIME.diameterInMillimeters());
		assertEquals(24.26, InsertedCoinPiece.QUARTER.diameterInMillimeters());
		assertEquals(25.8, InsertedCoinPiece.SLUG.diameterInMillimeters());
	}

	public void testWeightInGramsReturnsCorrectWeightForConstant() throws Exception {
		assertEquals(2.5, InsertedCoinPiece.PENNY.weightInGrams());
		assertEquals(5d, InsertedCoinPiece.NICKEL.weightInGrams());
		assertEquals(2.268, InsertedCoinPiece.DIME.weightInGrams());
		assertEquals(5.67, InsertedCoinPiece.QUARTER.weightInGrams());
		assertEquals(8.21, InsertedCoinPiece.SLUG.weightInGrams());
	}

}
