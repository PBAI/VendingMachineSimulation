package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserBalanceDisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTextField balanceDisplay;

	public UserBalanceDisplayPanel() {
		this.setName("UserBalanceDisplayPanel");
		this.balanceDisplay = new JTextField();
		this.balanceDisplay.setText("0.00");
		JLabel balanceLabel = new JLabel();
		balanceLabel.setText("Your Balance");

		this.add(balanceDisplay);
		this.add(balanceLabel);

	}

	public void showUpdatedBalance(String balanceToDisplay) {
		this.balanceDisplay.setText(balanceToDisplay);
	}

	public JTextField getBalanceDisplayTextField() {
		return this.balanceDisplay;
	}

}
