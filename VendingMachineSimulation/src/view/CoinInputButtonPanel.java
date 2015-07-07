package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CoinInputButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CoinInputButtonPanel() {
		this.setName("CoinInputButtonPanel");
		JButton pennyButton = makeButton("PennyButton", "Add Penny");
		JButton nickelButton = makeButton("NickelButton", "Add Nickel");
		JButton dimeButton = makeButton("DimeButton", "Add Dime");
		JButton quarterButton = makeButton("QuarterButton", "Add Quarter");
		JButton slugButton = makeButton("SlugButton", "Add Slug");

		this.add(pennyButton);
		this.add(nickelButton);
		this.add(dimeButton);
		this.add(quarterButton);
		this.add(slugButton);
	}

	private JButton makeButton(String buttonName, String buttonText) {
		JButton button = new JButton();
		button.setName(buttonName);
		button.setText(buttonText);
		return button;
	}
}
