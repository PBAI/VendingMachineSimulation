package startup;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.VendingWindow;
import view.VendingWindowInterface;
import control.CoinInsertionButtonListenerCollection;
import control.EmptyChangeSlotButtonListener;
import control.ReturnButtonListener;
import control.VendingButtonListener;
import control.VendingControllerInterface;

public class ViewControlConnector {

	private final VendingWindow vendingWindow;
	private final CoinInsertionButtonListenerCollection coinInsertionButtonListeners;
	private final EmptyChangeSlotButtonListener emptyChangeSlotButtonListener;
	private final ReturnButtonListener returnButtonListener;
	private final VendingButtonListener vendingButtonListener;
	private final VendingControllerInterface vendingController;

	public ViewControlConnector(CoinInsertionButtonListenerCollection coinInsertionButtonListeners,
			EmptyChangeSlotButtonListener emptyChangeSlotButtonListener,
			ReturnButtonListener returnButtonListener, VendingWindow vendingWindow,
			VendingControllerInterface vendingController) {
		this.coinInsertionButtonListeners = coinInsertionButtonListeners;
		this.vendingWindow = vendingWindow;
		this.emptyChangeSlotButtonListener = emptyChangeSlotButtonListener;
		this.returnButtonListener = returnButtonListener;
		this.vendingController = vendingController;
		this.vendingButtonListener = new VendingButtonListener(
				getVendingButtonsFromProductSelectionPanel(), this.vendingController);
	}

	public void connectProductSelectionButtonsToVendingButtonListener() {
		ArrayList<JPanel> buttonPanels = extractProductSelectionPanelButtonPanelsIntoList();
		JButton productAButton = (JButton) buttonPanels.get(0).getComponent(0);
		productAButton.addActionListener(this.vendingButtonListener);

		JButton productBButton = (JButton) buttonPanels.get(1).getComponent(0);
		productBButton.addActionListener(this.vendingButtonListener);

		JButton productCButton = (JButton) buttonPanels.get(2).getComponent(0);
		productCButton.addActionListener(this.vendingButtonListener);
	}

	public void connectCoinInsertionButtonsToButtonListeners() {
		ArrayList<JButton> coinInputButtons = extractButtonsFromCoinInputButtonPanel();
		coinInputButtons.get(0).addActionListener(
				this.coinInsertionButtonListeners.getPennyButtonListener());
		coinInputButtons.get(1).addActionListener(
				this.coinInsertionButtonListeners.getNickelButtonListener());
		coinInputButtons.get(2).addActionListener(
				this.coinInsertionButtonListeners.getDimeButtonListener());
		coinInputButtons.get(3).addActionListener(
				this.coinInsertionButtonListeners.getQuarterButtonListener());
		coinInputButtons.get(4).addActionListener(
				this.coinInsertionButtonListeners.getSlugButtonListener());
	}

	public void connectEmptyChangeSlotButtonToListener() {
		JButton emptyChangeSlotButton = getButtonFromSubPanel(2, 1, 0);
		emptyChangeSlotButton.addActionListener(this.emptyChangeSlotButtonListener);
	}

	public void connectReturnButtonToListener() {
		JButton returnButton = getButtonFromSubPanel(2, 2, 6);
		returnButton.addActionListener(this.returnButtonListener);
	}

	private JButton getButtonFromSubPanel(int subPanelNumber, int subComponentNumber,
			int buttonNumber) {
		Container contentPane = this.vendingWindow.getContentPane();
		JPanel subPanel = (JPanel) contentPane.getComponent(subPanelNumber);
		JPanel buttonPanel = (JPanel) subPanel.getComponent(subComponentNumber);
		JButton button = (JButton) buttonPanel.getComponent(buttonNumber);
		return button;
	}

	public CoinInsertionButtonListenerCollection getCoinInsertionButtonListeners() {
		return this.coinInsertionButtonListeners;
	}

	public VendingWindowInterface getVendingWindow() {
		return this.vendingWindow;
	}

	public EmptyChangeSlotButtonListener getEmptyChangeSlotButtonListener() {
		return this.emptyChangeSlotButtonListener;
	}

	public ReturnButtonListener getReturnButtonListener() {
		return returnButtonListener;
	}

	public VendingControllerInterface getVendingController() {
		return this.vendingController;
	}

	public VendingButtonListener getVendingButtonListener() {
		return this.vendingButtonListener;
	}

	private ArrayList<JPanel> extractProductSelectionPanelButtonPanelsIntoList() {
		Container contentPane = this.vendingWindow.getContentPane();
		JPanel firstSubPanel = (JPanel) contentPane.getComponent(0);
		ArrayList<JPanel> buttonPanels = new ArrayList<JPanel>();
		Component[] components = firstSubPanel.getComponents();
		for (Component component : components) {
			JPanel panel = (JPanel) component;
			buttonPanels.add(panel);
		}
		return buttonPanels;
	}

	private ArrayList<JButton> extractButtonsFromCoinInputButtonPanel() {
		ArrayList<JButton> coinInputButtons = new ArrayList<JButton>();
		JPanel secondSubPanel = (JPanel) this.vendingWindow.getContentPane().getComponent(1);
		JPanel coinInputButtonPanel = (JPanel) secondSubPanel.getComponent(2);
		for (Component component : coinInputButtonPanel.getComponents()) {
			JButton button = (JButton) component;
			coinInputButtons.add(button);
		}
		return coinInputButtons;
	}

	private ArrayList<JButton> getVendingButtonsFromProductSelectionPanel() {
		ArrayList<JPanel> vendingButtonPanels = extractProductSelectionPanelButtonPanelsIntoList();
		ArrayList<JButton> vendingButtons = new ArrayList<JButton>();
		for (JPanel panel : vendingButtonPanels) {
			vendingButtons.add((JButton) panel.getComponent(0));
		}
		return vendingButtons;
	}
}
