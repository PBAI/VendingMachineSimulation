package controlTest;

import model.CoinReturnTrayInterface;
import view.VendingWindowInterface;
import control.ChangeManagerInterface;

public class MockChangeManager implements ChangeManagerInterface {

	private boolean makeChangeWasCalled;
	private boolean clearChangeTotalWasCalled;
	private CoinReturnTrayInterface coinReturnTray;
	private boolean getCoinReturnTrayWasCalled;
	private VendingWindowInterface vendingWindow;
	private boolean getVendingWindowWasCalled;

	public MockChangeManager() {
		this.makeChangeWasCalled = false;
		this.clearChangeTotalWasCalled = false;
		this.getVendingWindowWasCalled = false;
		this.coinReturnTray = null;
		this.vendingWindow = null;
	}

	@Override
	public void makeChange() {
		this.makeChangeWasCalled = true;
	}

	@Override
	public void clearChangeValueTotal() {
		this.clearChangeTotalWasCalled = true;
	}

	@Override
	public CoinReturnTrayInterface getCoinReturnTray() {
		this.getCoinReturnTrayWasCalled = true;
		return coinReturnTray;
	}

	@Override
	public VendingWindowInterface getVendingWindow() {
		this.getVendingWindowWasCalled = true;
		return this.vendingWindow;
	}

	public boolean getMakeChangeWasCalled() {
		return this.makeChangeWasCalled;
	}

	public boolean getClearChangeValueTotalWasCalled() {
		return this.clearChangeTotalWasCalled;
	}

	public void setCoinReturnTrayToReturn(CoinReturnTrayInterface coinReturnTray) {
		this.coinReturnTray = coinReturnTray;
	}

	public void setVendingWindowToReturn(VendingWindowInterface vendingWindowToReturn) {
		this.vendingWindow = vendingWindowToReturn;
	}

	public boolean getGetCoinReturnTrayWasCalled() {
		return getCoinReturnTrayWasCalled;
	}

	public boolean getGetVendingWindowWasCalled() {
		return this.getVendingWindowWasCalled;
	}
}
