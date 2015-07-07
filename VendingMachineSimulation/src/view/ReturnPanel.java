package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTextField pennyTextField;
	private final JTextField nickelTextField;
	private final JTextField dimeTextField;
	private final JTextField quarterTextField;
	private final JTextField slugTextField;

	public ReturnPanel() {
		this.setName("ReturnPanel");
		JLabel returnPanelLabel = new JLabel();
		returnPanelLabel.setText("Coin Return");

		pennyTextField = new JTextField("Pennies: ", 20);
		nickelTextField = new JTextField("Nickels: ", 20);
		dimeTextField = new JTextField("Dimes: ", 20);
		quarterTextField = new JTextField("Quarters: ", 20);
		slugTextField = new JTextField("Slugs: ", 20);

		pennyTextField.setName("PennyReturnTextField");
		nickelTextField.setName("NickelReturnTextField");
		dimeTextField.setName("DimeReturnTextField");
		quarterTextField.setName("QuarterReturnTextField");
		slugTextField.setName("SlugReturnTextField");

		JButton returnButton = new JButton();
		returnButton.setName("ReturnButton");
		returnButton.setText("Return");

		this.add(returnPanelLabel);
		this.add(pennyTextField);
		this.add(nickelTextField);
		this.add(dimeTextField);
		this.add(quarterTextField);
		this.add(slugTextField);
		this.add(returnButton);
	}

	public void showPennyTextFieldUpdatedAmount(int amountToDisplay) {
		this.pennyTextField.setText("Pennies: " + amountToDisplay);
	}

	public void showNickelTextFieldUpdatedAmount(int amountToDisplay) {
		this.nickelTextField.setText("Nickels: " + amountToDisplay);
	}

	public void showDimeTextFieldUpdatedAmount(int amountToDisplay) {
		this.dimeTextField.setText("Dimes: " + amountToDisplay);
	}

	public void showQuarterTextFieldUpdatedAmount(int amountToDisplay) {
		this.quarterTextField.setText("Quarters: " + amountToDisplay);
	}

	public void showSlugTextFieldUpdatedAmount(int amountToDisplay) {
		this.slugTextField.setText("Slugs: " + amountToDisplay);
	}

	public JTextField getPennyTextField() {
		return this.pennyTextField;
	}

	public JTextField getNickelTextField() {
		return this.nickelTextField;
	}

	public JTextField getDimeTextField() {
		return this.dimeTextField;
	}

	public JTextField getQuarterTextField() {
		return this.quarterTextField;
	}

	public JTextField getSlugTextField() {
		return this.slugTextField;
	}
}
