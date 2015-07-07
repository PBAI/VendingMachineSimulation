package modelTest;

import model.ChangeValueInterface;

public class MockChangeValue implements ChangeValueInterface {

	private boolean clearTotalWasCalled;
	private boolean getTotalAsFormattedStringWasCalled;
	private boolean addToTotalWasCalled;
	private int numberOfTimesGetTotalAsFormattedStringWasCalled;
	private int numberOfTimesAddToTotalWasCalled;

	public MockChangeValue() {
		this.clearTotalWasCalled = false;
		this.getTotalAsFormattedStringWasCalled = false;
		this.addToTotalWasCalled = false;
		this.numberOfTimesAddToTotalWasCalled = 0;
		this.numberOfTimesGetTotalAsFormattedStringWasCalled = 0;
	}

	@Override
	public void clearTotal() {
		this.clearTotalWasCalled = true;
	}

	@Override
	public String getTotalAsFormattedString() {
		this.numberOfTimesGetTotalAsFormattedStringWasCalled++;
		this.getTotalAsFormattedStringWasCalled = true;
		return null;
	}

	@Override
	public void addToTotal(double amountToAdd) {
		this.numberOfTimesAddToTotalWasCalled++;
		this.addToTotalWasCalled = true;
	}

	public boolean getClearTotalWasCalled() {
		return this.clearTotalWasCalled;
	}

	public boolean getGetTotalAsFormatedStringWasCalled() {
		return this.getTotalAsFormattedStringWasCalled;
	}

	public boolean getAddToTotalWasCalled() {
		return this.addToTotalWasCalled;
	}

	public int getNumberOfTimesGetTotalAsFormattedStringWasCalled() {
		return this.numberOfTimesGetTotalAsFormattedStringWasCalled;
	}

	public int getNumberOfTimesAddToTotalWasCalled() {
		return this.numberOfTimesAddToTotalWasCalled;
	}
}
