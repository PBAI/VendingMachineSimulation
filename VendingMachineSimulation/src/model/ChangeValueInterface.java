package model;

public interface ChangeValueInterface {

	public abstract void clearTotal();

	public abstract String getTotalAsFormattedString();

	public abstract void addToTotal(double amountToAdd);

}
