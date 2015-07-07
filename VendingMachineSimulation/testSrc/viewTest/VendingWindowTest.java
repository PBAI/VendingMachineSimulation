package viewTest;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import junit.framework.TestCase;
import view.CoinInputButtonPanel;
import view.CoinReturnDisplayPanel;
import view.EmptyChangeSlotButtonPanel;
import view.ReturnPanel;
import view.UserBalanceDisplayPanel;
import view.UserCommunicationDisplayPanel;
import view.VendingWindow;
import view.VendingWindowInterface;

public class VendingWindowTest extends TestCase {

	public void testImplementsVendingWindowInterface() throws Exception {
		assertEquals(1, VendingWindow.class.getInterfaces().length);
		assertSame(VendingWindowInterface.class, VendingWindow.class.getInterfaces()[0]);
	}

	public void testExtendsJFrame() throws Exception {
		assertSame(JFrame.class, VendingWindow.class.getSuperclass());
	}

	public void testSizeOfVendingWindow() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		Dimension expectedWindowSize = new Dimension(1000, 800);
		assertEquals(expectedWindowSize, vendingWindow.getSize());
	}

	public void testVendingWindowTitle() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		String expectedTitle = "Vending Machine Simulation";
		assertEquals(expectedTitle, vendingWindow.getTitle());
	}

	public void testDefaultCloseOperationIsExitOnClose() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int expectedDefaultCloseOperationNumber = 3;
		assertEquals(expectedDefaultCloseOperationNumber, vendingWindow.getDefaultCloseOperation());
	}

	public void testContentPaneHasName() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		assertEquals("ContentPane", vendingWindow.getContentPane().getName());
	}

	public void testVendingWindowContentPaneUsesBoxLayout() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		Container contentPane = vendingWindow.getContentPane();
		assertEquals(BoxLayout.class.toString(), contentPane.getLayout().getClass().toString());
	}

	public void testVendingWindowHasThreeSubSectionPanels() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		assertEquals(3, vendingWindow.getContentPane().getComponentCount());
		Component[] subSectionPanels = vendingWindow.getContentPane().getComponents();

		String expectedFirstSubSectionPanelName = "ProductSelectionPanel";
		Component panelOne = subSectionPanels[0];
		assertEquals(JPanel.class, panelOne.getClass());
		assertEquals(expectedFirstSubSectionPanelName, panelOne.getName());

		String expectedSecondSubSectionPanelName = "DisplayAndCoinInsertionPanel";
		Component panelTwo = subSectionPanels[1];
		assertEquals(JPanel.class, panelTwo.getClass());
		assertEquals(expectedSecondSubSectionPanelName, panelTwo.getName());

		String expectedThirdSubSectionPanelName = "CoinReturnAndExactChangeModePanel";
		Component panelThree = subSectionPanels[2];
		assertEquals(JPanel.class, panelThree.getClass());
		assertEquals(expectedThirdSubSectionPanelName, panelThree.getName());
	}

	public void testProductSelectionPanelUsesFlowLayout() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);
		assertEquals(FlowLayout.class, productSelectionPanel.getLayout().getClass());
	}

	public void testDisplayAndCoinInsertionPanelUsesBoxLayout() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 1;
		JPanel displayAndCoinInsertionPanel = getSubPanelFromContentPane(vendingWindow,
				subPanelNumber);
		assertSame(BoxLayout.class, displayAndCoinInsertionPanel.getLayout().getClass());
	}

	public void testReturnAndExactChangeModePanelUserBoxLayout() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 2;
		JPanel returnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow,
				subPanelNumber);
		assertSame(BoxLayout.class, returnAndExactChangeModePanel.getLayout().getClass());
	}

	public void testProductSelectionPanelHasThreeProductButtonAndPriceDisplayPanels()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);

		int expectedComponentCount = 3;
		assertEquals(expectedComponentCount, productSelectionPanel.getComponentCount());
		Component[] productButtonAndProductTypeDisplayPanels = productSelectionPanel
				.getComponents();

		Component productButtonPanelOne = productButtonAndProductTypeDisplayPanels[0];
		assertEquals(JPanel.class, productButtonPanelOne.getClass());
		assertEquals("ProductAButtonAndProductTypeDisplayPanel", productButtonPanelOne.getName());

		Component productButtonPanelTwo = productButtonAndProductTypeDisplayPanels[1];
		assertEquals(JPanel.class, productButtonPanelTwo.getClass());
		assertEquals("ProductBButtonAndProductTypeDisplayPanel", productButtonPanelTwo.getName());

		Component productButtonPanelThree = productButtonAndProductTypeDisplayPanels[2];
		assertEquals(JPanel.class, productButtonPanelThree.getClass());
		assertEquals("ProductCButtonAndProductTypeDisplayPanel", productButtonPanelThree.getName());
	}

	public void testProductButtonAndPriceDisplayPanelsUseFlowLayout() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);
		ArrayList<JPanel> productButtonAndPriceDisplayPanels = makeArrayListOfJPanelsFromProductSelectionPanelComponents(productSelectionPanel);
		for (JPanel jPanel : productButtonAndPriceDisplayPanels) {
			assertSame(FlowLayout.class, jPanel.getLayout().getClass());
		}
	}

	public void testProductDisplayButtonNamesAndDisplayText_ProductAPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);
		ArrayList<JPanel> productButtonAndPriceDisplayPanels = makeArrayListOfJPanelsFromProductSelectionPanelComponents(productSelectionPanel);

		JPanel panelA = productButtonAndPriceDisplayPanels.get(0);
		assertEquals(2, panelA.getComponentCount());

		Component panelAFirstComponent = panelA.getComponent(0);
		assertEquals(JButton.class, panelAFirstComponent.getClass());
		JButton panelAButton = (JButton) panelAFirstComponent;
		assertEquals("ProductAButton", panelAButton.getName());
		assertEquals("Push To Vend", panelAButton.getText());

		Component panelASecondComponent = panelA.getComponent(1);
		assertEquals(JLabel.class, panelASecondComponent.getClass());
		JLabel panelALabel = (JLabel) panelASecondComponent;
		assertEquals("ColaLabel", panelALabel.getName());
		assertEquals("Cola", panelALabel.getText());
	}

	public void testProductDisplayButtonNamesAndDisplayText_ProductBPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);
		ArrayList<JPanel> productButtonAndPriceDisplayPanels = makeArrayListOfJPanelsFromProductSelectionPanelComponents(productSelectionPanel);

		JPanel panelB = productButtonAndPriceDisplayPanels.get(1);
		assertEquals(2, panelB.getComponentCount());

		Component panelBFirstComponent = panelB.getComponent(0);
		assertEquals(JButton.class, panelBFirstComponent.getClass());
		JButton panelBButton = (JButton) panelBFirstComponent;
		assertEquals("ProductBButton", panelBButton.getName());
		assertEquals("Push To Vend", panelBButton.getText());

		Component panelBSecondComponent = panelB.getComponent(1);
		assertEquals(JLabel.class, panelBSecondComponent.getClass());
		JLabel panelBLabel = (JLabel) panelBSecondComponent;
		assertEquals("ChipsLabel", panelBLabel.getName());
		assertEquals("Chips", panelBLabel.getText());
	}

	public void testProductDisplayButtonNamesAndDisplayText_ProductCPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int subPanelNumber = 0;
		JPanel productSelectionPanel = getSubPanelFromContentPane(vendingWindow, subPanelNumber);
		ArrayList<JPanel> productButtonAndPriceDisplayPanels = makeArrayListOfJPanelsFromProductSelectionPanelComponents(productSelectionPanel);

		JPanel panelC = productButtonAndPriceDisplayPanels.get(2);
		assertEquals(2, panelC.getComponentCount());

		Component panelCFirstComponent = panelC.getComponent(0);
		assertEquals(JButton.class, panelCFirstComponent.getClass());
		JButton panelCButton = (JButton) panelCFirstComponent;
		assertEquals("ProductCButton", panelCButton.getName());
		assertEquals("Push To Vend", panelCButton.getText());

		Component panelCSecondComponent = panelC.getComponent(1);
		assertEquals(JLabel.class, panelCSecondComponent.getClass());
		JLabel panelCLabel = (JLabel) panelCSecondComponent;
		assertEquals("CandyLabel", panelCLabel.getName());
		assertEquals("Candy", panelCLabel.getText());
	}

	private ArrayList<JPanel> makeArrayListOfJPanelsFromProductSelectionPanelComponents(
			JPanel productSelectionPanel) {
		ArrayList<JPanel> productButtonAndPriceDisplayPanels = new ArrayList<JPanel>();
		for (Component buttonPanel : productSelectionPanel.getComponents()) {
			JPanel panel = (JPanel) buttonPanel;
			productButtonAndPriceDisplayPanels.add(panel);
		}
		return productButtonAndPriceDisplayPanels;
	}

	public void testDisplayAndCoinInsertionPanelHasUserCommunicationDisplayPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		Container contentPane = vendingWindow.getContentPane();
		JPanel displayAndCoinInsertionPanel = (JPanel) contentPane.getComponent(1);
		assertEquals(UserCommunicationDisplayPanel.class, displayAndCoinInsertionPanel
				.getComponent(0).getClass());
		assertSame(vendingWindow.getUserCommunicationDisplayPanel(),
				displayAndCoinInsertionPanel.getComponent(0));
	}

	public void testDisplayAndCoinInsertionPanelHasUserBalanceDisplayPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		Container contentPane = vendingWindow.getContentPane();
		JPanel displayAndCoinInsertionPanel = (JPanel) contentPane.getComponent(1);
		assertEquals(UserBalanceDisplayPanel.class, displayAndCoinInsertionPanel.getComponent(1)
				.getClass());
		assertSame(vendingWindow.getUserBalanceDisplayPanel(),
				displayAndCoinInsertionPanel.getComponent(1));
	}

	public void testDisplayAndCoinInsertionPanelHasCoinInputButtonPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		Container contentPane = vendingWindow.getContentPane();
		JPanel displayAndCoinInsertionPanel = (JPanel) contentPane.getComponent(1);
		assertEquals(CoinInputButtonPanel.class, displayAndCoinInsertionPanel.getComponent(2)
				.getClass());
		assertSame(vendingWindow.getCoinInputButtonPanel(),
				displayAndCoinInsertionPanel.getComponent(2));
	}

	public void testCoinReturnAndExactChangeModePanelHasCoinReturnDisplayPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JPanel coinReturnAndExactChangePanel = getSubPanelFromContentPane(vendingWindow, 2);
		assertSame(CoinReturnDisplayPanel.class, coinReturnAndExactChangePanel.getComponent(0)
				.getClass());
		assertSame(vendingWindow.getCoinReturnDisplayPanel(),
				coinReturnAndExactChangePanel.getComponent(0));
	}

	public void testCoinReturnAndExactChangeModePanelHasEmptyChangeSlotButtonPanel()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JPanel coinReturnAndExactChangePanel = getSubPanelFromContentPane(vendingWindow, 2);
		assertSame(EmptyChangeSlotButtonPanel.class, coinReturnAndExactChangePanel.getComponent(1)
				.getClass());
	}

	public void testCoinReturnAndExactChangeModePanelHasReturnPanel() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JPanel coinReturnAndExactChangePanel = getSubPanelFromContentPane(vendingWindow, 2);
		assertSame(ReturnPanel.class, coinReturnAndExactChangePanel.getComponent(2).getClass());
	}

	public void testShowThankYouMessage() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		vendingWindow.showThankYouMessage();
		JTextField displayTextField = getTextFieldFromUserCommunicationDisplayPanel(vendingWindow);
		String expectedText = "THANK YOU!";
		assertEquals(expectedText, displayTextField.getText());
	}

	public void testShowInsertCoinsMessage() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		vendingWindow.showThankYouMessage();
		vendingWindow.showInsertCoinsMessage();
		JTextField displayTextField = getTextFieldFromUserCommunicationDisplayPanel(vendingWindow);
		String expectedText = "INSERT COIN";
		assertEquals(expectedText, displayTextField.getText());
	}

	public void testShowPriceMessage() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		String priceToDisplay = "1.50";
		vendingWindow.showPriceMessage(priceToDisplay);
		JTextField displayTextField = getTextFieldFromUserCommunicationDisplayPanel(vendingWindow);
		String expectedText = "Price: " + priceToDisplay;
		assertEquals(expectedText, displayTextField.getText());
	}

	public void testShowSoldOutMessage() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		vendingWindow.showSoldOutMessage();
		JTextField displayTextField = getTextFieldFromUserCommunicationDisplayPanel(vendingWindow);
		String expectedText = "SOLD OUT";
		assertEquals(expectedText, displayTextField.getText());
	}

	public void testShowUpdatedUserBalance() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		String balanceToDisplay = "2.35";
		vendingWindow.showUpdatedUserBalance(balanceToDisplay);
		JTextField textField = getTextFieldFromUserBalancePanel(vendingWindow);
		assertEquals(balanceToDisplay, textField.getText());
	}

	public void testShowUpdatedChangeDisplay() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		String changeBalanceToDisplay = "0.45";
		vendingWindow.showUpdatedChangeDisplay(changeBalanceToDisplay);
		JTextField textField = (JTextField) vendingWindow.getCoinReturnDisplayPanel().getComponent(
				1);
		assertEquals(changeBalanceToDisplay, textField.getText());
	}

	public void testShowReturnedPennyAmount() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int amountToShow = 5;
		vendingWindow.showReturnedPennyAmount(amountToShow);
		JPanel coinReturnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow, 2);
		JPanel returnPanel = (JPanel) coinReturnAndExactChangeModePanel.getComponent(2);
		JTextField pennyTextField = (JTextField) returnPanel.getComponent(1);
		assertEquals("Pennies: " + amountToShow, pennyTextField.getText());
	}

	public void testShowReturnedNickelAmount() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int amountToShow = 4;
		vendingWindow.showReturnedNickelAmount(amountToShow);
		JPanel coinReturnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow, 2);
		JPanel returnPanel = (JPanel) coinReturnAndExactChangeModePanel.getComponent(2);
		JTextField nickelTextField = (JTextField) returnPanel.getComponent(2);
		assertEquals("Nickels: " + amountToShow, nickelTextField.getText());
	}

	public void testShowReturnedDimeAmount() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int amountToShow = 3;
		vendingWindow.showReturnedDimeAmount(amountToShow);
		JPanel coinReturnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow, 2);
		JPanel returnPanel = (JPanel) coinReturnAndExactChangeModePanel.getComponent(2);
		JTextField dimeTextField = (JTextField) returnPanel.getComponent(3);
		assertEquals("Dimes: " + amountToShow, dimeTextField.getText());
	}

	public void testShowReturnedQuarterAmount() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int amountToShow = 2;
		vendingWindow.showReturnedQuarterAmount(amountToShow);
		JPanel coinReturnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow, 2);
		JPanel returnPanel = (JPanel) coinReturnAndExactChangeModePanel.getComponent(2);
		JTextField quarterTextField = (JTextField) returnPanel.getComponent(4);
		assertEquals("Quarters: " + amountToShow, quarterTextField.getText());
	}

	public void testShowReturnedSlugAmount() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		int amountToShow = 1;
		vendingWindow.showReturnedSlugAmount(amountToShow);
		JPanel coinReturnAndExactChangeModePanel = getSubPanelFromContentPane(vendingWindow, 2);
		JPanel returnPanel = (JPanel) coinReturnAndExactChangeModePanel.getComponent(2);
		JTextField slugTextField = (JTextField) returnPanel.getComponent(5);
		assertEquals("Slugs: " + amountToShow, slugTextField.getText());
	}

	private JPanel getSubPanelFromContentPane(VendingWindow vendingWindow, int subPanelNumber) {
		Container contentPane = vendingWindow.getContentPane();
		JPanel subPanel = (JPanel) contentPane.getComponent(subPanelNumber);
		return subPanel;
	}

	private JTextField getTextFieldFromUserBalancePanel(VendingWindow vendingWindow) {
		Container contentPane = vendingWindow.getContentPane();
		JPanel displayAndCoinInsertionPanel = (JPanel) contentPane.getComponent(1);
		JPanel userBalanceDisplayPanel = (JPanel) displayAndCoinInsertionPanel.getComponent(1);
		JTextField textField = (JTextField) userBalanceDisplayPanel.getComponent(0);
		return textField;
	}

	private JTextField getTextFieldFromUserCommunicationDisplayPanel(VendingWindow vendingWindow) {
		Container contentPane = vendingWindow.getContentPane();
		JPanel displayAndCoinInsertionPanel = (JPanel) contentPane.getComponent(1);
		JPanel userCommunicationDisplayPanel = (JPanel) displayAndCoinInsertionPanel
				.getComponent(0);
		JTextField displayTextField = (JTextField) userCommunicationDisplayPanel.getComponent(0);
		return displayTextField;
	}
}
