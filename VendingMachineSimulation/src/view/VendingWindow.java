package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VendingWindow extends JFrame implements VendingWindowInterface {

	private static final long serialVersionUID = 1L;
	private final UserCommunicationDisplayPanel userCommunicationDisplayPanel;
	private final UserBalanceDisplayPanel userBalanceDisplayPanel;
	private final CoinInputButtonPanel coinInputButtonPanel;
	private final CoinReturnDisplayPanel coinReturnDisplayPanel;
	private final EmptyChangeSlotButtonPanel emptyChangeSlotButtonPanel;
	private final ReturnPanel returnPanel;

	public VendingWindow() {
		this.setSize(new Dimension(1000, 800));
		this.setTitle("Vending Machine Simulation");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setName("ContentPane");
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.userCommunicationDisplayPanel = new UserCommunicationDisplayPanel();
		this.userBalanceDisplayPanel = new UserBalanceDisplayPanel();
		this.coinInputButtonPanel = new CoinInputButtonPanel();
		this.coinReturnDisplayPanel = new CoinReturnDisplayPanel();
		this.emptyChangeSlotButtonPanel = new EmptyChangeSlotButtonPanel();
		this.returnPanel = new ReturnPanel();

		addProductSelectionPanel(contentPane);
		addDisplayAndCoinInsertionPanel(contentPane);
		addCoinReturnAndExactChangeModePanel(contentPane);
	}

	private void addProductSelectionPanel(Container contentPane) {
		JPanel productSelectionPanel = new JPanel();
		productSelectionPanel.setName("ProductSelectionPanel");
		addButtonAndLabelPanelsToProductSelectionPanel(productSelectionPanel);
		contentPane.add(productSelectionPanel);
	}

	private void addButtonAndLabelPanelsToProductSelectionPanel(JPanel productSelectionPanel) {
		JPanel productA_ButtonAndLabelPanel = new JPanel();
		productA_ButtonAndLabelPanel.setName("ProductAButtonAndProductTypeDisplayPanel");
		addButtonToProductButtonPanel(productA_ButtonAndLabelPanel, "ProductAButton",
				"Push To Vend");
		addLabelToProductButtonPanel(productA_ButtonAndLabelPanel, "ColaLabel", "Cola");

		JPanel productB_ButtonAndLabelPanel = new JPanel();
		productB_ButtonAndLabelPanel.setName("ProductBButtonAndProductTypeDisplayPanel");
		addButtonToProductButtonPanel(productB_ButtonAndLabelPanel, "ProductBButton",
				"Push To Vend");
		addLabelToProductButtonPanel(productB_ButtonAndLabelPanel, "ChipsLabel", "Chips");

		JPanel productC_ButtonAndLabelPanel = new JPanel();
		productC_ButtonAndLabelPanel.setName("ProductCButtonAndProductTypeDisplayPanel");
		addButtonToProductButtonPanel(productC_ButtonAndLabelPanel, "ProductCButton",
				"Push To Vend");
		addLabelToProductButtonPanel(productC_ButtonAndLabelPanel, "CandyLabel", "Candy");

		productSelectionPanel.add(productA_ButtonAndLabelPanel);
		productSelectionPanel.add(productB_ButtonAndLabelPanel);
		productSelectionPanel.add(productC_ButtonAndLabelPanel);
	}

	@Override
	public void showThankYouMessage() {
		this.userCommunicationDisplayPanel.setThankYouText();
	}

	@Override
	public void showInsertCoinsMessage() {
		this.userCommunicationDisplayPanel.setInsertCoinsText();
	}

	@Override
	public void showPriceMessage(String priceToDisplay) {
		this.userCommunicationDisplayPanel.setPriceText(priceToDisplay);
	}

	@Override
	public void showSoldOutMessage() {
		this.userCommunicationDisplayPanel.setSoldOutText();
	}

	@Override
	public void showUpdatedUserBalance(String balanceToDisplay) {
		this.userBalanceDisplayPanel.showUpdatedBalance(balanceToDisplay);
	}

	@Override
	public void showUpdatedChangeDisplay(String changeBalanceToDisplay) {
		this.coinReturnDisplayPanel.showValidChangeAmount(changeBalanceToDisplay);
	}

	@Override
	public void showReturnedPennyAmount(int amountToShow) {
		this.returnPanel.showPennyTextFieldUpdatedAmount(amountToShow);
	}

	@Override
	public void showReturnedNickelAmount(int amountToShow) {
		this.returnPanel.showNickelTextFieldUpdatedAmount(amountToShow);
	}

	@Override
	public void showReturnedDimeAmount(int amountToShow) {
		this.returnPanel.showDimeTextFieldUpdatedAmount(amountToShow);
	}

	@Override
	public void showReturnedQuarterAmount(int amountToShow) {
		this.returnPanel.showQuarterTextFieldUpdatedAmount(amountToShow);
	}

	@Override
	public void showReturnedSlugAmount(int amountToShow) {
		this.returnPanel.showSlugTextFieldUpdatedAmount(amountToShow);
	}

	public UserCommunicationDisplayPanel getUserCommunicationDisplayPanel() {
		return this.userCommunicationDisplayPanel;
	}

	public UserBalanceDisplayPanel getUserBalanceDisplayPanel() {
		return this.userBalanceDisplayPanel;
	}

	public CoinInputButtonPanel getCoinInputButtonPanel() {
		return this.coinInputButtonPanel;
	}

	public CoinReturnDisplayPanel getCoinReturnDisplayPanel() {
		return this.coinReturnDisplayPanel;
	}

	private void addButtonToProductButtonPanel(
			JPanel productSelectionButtonAndProductTypeDisplayPanel, String buttonName,
			String buttonDisplayText) {
		JButton productButton = new JButton(buttonDisplayText);
		productButton.setName(buttonName);
		productSelectionButtonAndProductTypeDisplayPanel.add(productButton);
	}

	private void addLabelToProductButtonPanel(
			JPanel productSelectionButtonAndProductTypeDisplayPanel, String labelName,
			String labelText) {
		JLabel productTypeLabel = new JLabel(labelText);
		productTypeLabel.setName(labelName);
		productSelectionButtonAndProductTypeDisplayPanel.add(productTypeLabel);
	}

	private void addDisplayAndCoinInsertionPanel(Container contentPane) {
		JPanel displayAndCoinInsertionPanel = new JPanel();
		displayAndCoinInsertionPanel.setName("DisplayAndCoinInsertionPanel");
		displayAndCoinInsertionPanel.setLayout(new BoxLayout(displayAndCoinInsertionPanel,
				BoxLayout.X_AXIS));
		displayAndCoinInsertionPanel.add(this.userCommunicationDisplayPanel);
		displayAndCoinInsertionPanel.add(this.userBalanceDisplayPanel);
		displayAndCoinInsertionPanel.add(this.coinInputButtonPanel);
		contentPane.add(displayAndCoinInsertionPanel);
	}

	private void addCoinReturnAndExactChangeModePanel(Container contentPane) {
		JPanel returnAndExactChangeModePanel = new JPanel();
		returnAndExactChangeModePanel.setName("CoinReturnAndExactChangeModePanel");
		returnAndExactChangeModePanel.setLayout(new BoxLayout(returnAndExactChangeModePanel,
				BoxLayout.X_AXIS));
		returnAndExactChangeModePanel.add(this.coinReturnDisplayPanel);
		returnAndExactChangeModePanel.add(this.emptyChangeSlotButtonPanel);
		returnAndExactChangeModePanel.add(this.returnPanel);
		contentPane.add(returnAndExactChangeModePanel);
	}
}
