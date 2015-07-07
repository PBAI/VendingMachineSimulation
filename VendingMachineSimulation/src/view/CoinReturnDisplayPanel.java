package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoinReturnDisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel changeLabel;
	private final JTextField changeDisplay;

	public CoinReturnDisplayPanel() {
		this.setName("CoinReturnDisplayPanel");
		this.changeLabel = new JLabel();
		this.changeLabel.setText("Change:");
		this.changeDisplay = new JTextField();
		this.changeDisplay.setText("0.00");
		this.add(changeLabel);
		this.add(this.changeDisplay);
	}

	public JLabel getChangeLabel() {
		return this.changeLabel;
	}

	public JTextField getChangeDisplayTextField() {
		return this.changeDisplay;
	}

	public void showValidChangeAmount(String validChange) {
		this.changeDisplay.setText(validChange);
	}
}
