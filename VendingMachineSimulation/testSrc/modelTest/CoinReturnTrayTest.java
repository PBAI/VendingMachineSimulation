package modelTest;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.CoinReturnTray;
import model.CoinReturnTrayInterface;
import model.InsertedCoinPiece;

public class CoinReturnTrayTest extends TestCase {

	public void testImplementsCoinReturnTrayInterface() throws Exception {
		assertEquals(1, CoinReturnTray.class.getInterfaces().length);
		assertEquals(CoinReturnTrayInterface.class, CoinReturnTray.class.getInterfaces()[0]);
	}

	public void testGetAllReturnTrayCoins() throws Exception {
		CoinReturnTray coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getAllReturnTrayCoins().getClass());
		assertEquals(0, coinReturnTray.getAllReturnTrayCoins().size());
	}

	public void testGetPennies() throws Exception {
		CoinReturnTrayInterface coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getPenniesInTray().getClass());
		assertEquals(0, coinReturnTray.getPenniesInTray().size());
	}

	public void testGetNickels() throws Exception {
		CoinReturnTrayInterface coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getNickelsInTray().getClass());
		assertEquals(0, coinReturnTray.getNickelsInTray().size());
	}

	public void testGetDimes() throws Exception {
		CoinReturnTrayInterface coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getDimesInTray().getClass());
		assertEquals(0, coinReturnTray.getDimesInTray().size());
	}

	public void testGetQuarters() throws Exception {
		CoinReturnTrayInterface coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getQuartersInTray().getClass());
		assertEquals(0, coinReturnTray.getQuartersInTray().size());
	}

	public void testGetSlugs() throws Exception {
		CoinReturnTrayInterface coinReturnTray = new CoinReturnTray();
		assertSame(ArrayList.class, coinReturnTray.getSlugsInTray().getClass());
		assertEquals(0, coinReturnTray.getSlugsInTray().size());
	}

	public void testAddInsertedCoinToReturnTray() throws Exception {
		CoinReturnTray coinReturnTray = new CoinReturnTray();
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.SLUG);
		assertEquals(1, coinReturnTray.getAllReturnTrayCoins().size());

		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.QUARTER);
		assertEquals(2, coinReturnTray.getAllReturnTrayCoins().size());
	}

	public void testEmptyReturnTray() throws Exception {
		CoinReturnTray coinReturnTray = new CoinReturnTray();
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.SLUG);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.DIME);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.NICKEL);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.PENNY);
		assertEquals(5, coinReturnTray.getAllReturnTrayCoins().size());

		coinReturnTray.emptyReturnTray();
		assertEquals(0, coinReturnTray.getAllReturnTrayCoins().size());
		assertEquals(0, coinReturnTray.getSlugsInTray().size());
		assertEquals(0, coinReturnTray.getQuartersInTray().size());
		assertEquals(0, coinReturnTray.getDimesInTray().size());
		assertEquals(0, coinReturnTray.getNickelsInTray().size());
		assertEquals(0, coinReturnTray.getPenniesInTray().size());
	}

	public void testInsertedCoinsGetPlacedInCorrectList() throws Exception {
		CoinReturnTray coinReturnTray = new CoinReturnTray();
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.PENNY);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.NICKEL);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.DIME);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.QUARTER);
		coinReturnTray.addInsertedCoinToReturnTray(InsertedCoinPiece.SLUG);

		assertEquals(5, coinReturnTray.getAllReturnTrayCoins().size());
		assertEquals(1, coinReturnTray.getPenniesInTray().size());
		assertEquals(1, coinReturnTray.getNickelsInTray().size());
		assertEquals(1, coinReturnTray.getDimesInTray().size());
		assertEquals(1, coinReturnTray.getQuartersInTray().size());
		assertEquals(1, coinReturnTray.getSlugsInTray().size());
	}
}
