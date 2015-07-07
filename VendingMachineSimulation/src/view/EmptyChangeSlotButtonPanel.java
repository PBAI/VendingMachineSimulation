package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmptyChangeSlotButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JButton emptyChangeSlotButton;

	public EmptyChangeSlotButtonPanel() {
		this.setName("EmptyChangeSlotButtonPanel");
		emptyChangeSlotButton = new JButton();
		emptyChangeSlotButton.setName("EmptyChangeSlotButton");
		emptyChangeSlotButton.setText("Collect Change");
		this.add(emptyChangeSlotButton);
	}

	public JButton getEmptyChangeSlotButton() {
		return this.emptyChangeSlotButton;
	}
}
