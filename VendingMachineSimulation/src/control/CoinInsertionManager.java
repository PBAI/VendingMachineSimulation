package control;

import java.text.DecimalFormat;

import model.CoinReturnTrayInterface;
import model.InsertedCoinPiece;
import model.UserBalanceInterface;
import view.VendingWindowInterface;

public class CoinInsertionManager implements CoinInsertionManagerInterface {

	private final CoinValidatorInterface coinValidator;
	private final UserBalanceInterface userBalance;
	private final CoinReturnTrayInterface coinReturnTray;
	private final VendingWindowInterface vendingWindow;

	public CoinInsertionManager(CoinValidatorInterface coinValidator,
			UserBalanceInterface userBalance, CoinReturnTrayInterface coinReturnTray,
			VendingWindowInterface vendingWindow) {
		this.coinValidator = coinValidator;
		this.userBalance = userBalance;
		this.coinReturnTray = coinReturnTray;
		this.vendingWindow = vendingWindow;
	}

	@Override
	public void addInsertedCoinValueToUserBalanceIfCoinIsValid(InsertedCoinPiece insertedCoin) {
		if (this.coinValidator.coinIsValid(insertedCoin)) {
			this.userBalance.addFunds(insertedCoin);
			String balanceToDisplay = formatUserBalanceAsString();
			this.vendingWindow.showUpdatedUserBalance(balanceToDisplay);
		} else {
			returnCoin(insertedCoin);
		}
	}

	private String formatUserBalanceAsString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String balanceToDisplay = decimalFormat.format(this.userBalance.getBalanceValue())
				.toString();
		return balanceToDisplay;
	}

	@Override
	public void returnCoin(InsertedCoinPiece coinToReturn) {
		this.coinReturnTray.addInsertedCoinToReturnTray(coinToReturn);
		this.vendingWindow.showReturnedSlugAmount(this.coinReturnTray.getSlugsInTray().size());
		this.vendingWindow
				.showReturnedQuarterAmount(this.coinReturnTray.getQuartersInTray().size());
		this.vendingWindow.showReturnedDimeAmount(this.coinReturnTray.getDimesInTray().size());
		this.vendingWindow.showReturnedNickelAmount(this.coinReturnTray.getNickelsInTray().size());
		this.vendingWindow.showReturnedPennyAmount(this.coinReturnTray.getPenniesInTray().size());
	}

	public CoinValidatorInterface getCoinValidator() {
		return this.coinValidator;
	}

	public UserBalanceInterface getUserBalance() {
		return this.userBalance;
	}

	public CoinReturnTrayInterface getCoinReturnTray() {
		return this.coinReturnTray;
	}

	public VendingWindowInterface getVendingWindow() {
		return this.vendingWindow;
	}
}
