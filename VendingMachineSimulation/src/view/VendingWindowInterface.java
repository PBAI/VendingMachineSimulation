package view;

public interface VendingWindowInterface {

	public abstract void showPriceMessage(String priceToDisplay);

	public abstract void showInsertCoinsMessage();

	public abstract void showThankYouMessage();

	public abstract void showSoldOutMessage();

	public abstract void showUpdatedUserBalance(String balanceToDisplay);

	public abstract void showUpdatedChangeDisplay(String changeBalanceToDisplay);

	public abstract void showReturnedSlugAmount(int amountToShow);

	public abstract void showReturnedQuarterAmount(int amountToShow);

	public abstract void showReturnedDimeAmount(int amountToShow);

	public abstract void showReturnedNickelAmount(int amountToShow);

	public abstract void showReturnedPennyAmount(int amountToShow);

}
