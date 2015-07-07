package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserCommunicationDisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTextField userCommunicationTextField;

	public UserCommunicationDisplayPanel() {
		this.setName("UserCommunicationDisplayPanel");
		this.userCommunicationTextField = new JTextField();
		this.add(this.userCommunicationTextField);
		setInsertCoinsText();

	}

	public void setInsertCoinsText() {
		this.userCommunicationTextField.setText("INSERT COIN");
	}

	public void setPriceText(String priceText) {
		this.userCommunicationTextField.setText("Price: " + priceText);
	}

	public void setThankYouText() {
		this.userCommunicationTextField.setText("THANK YOU!");
	}

	public void setSoldOutText() {
		this.userCommunicationTextField.setText("SOLD OUT");
	}

}
