package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnButtonListener implements ActionListener {

	private final ChangeManagerInterface changeManager;

	public ReturnButtonListener(ChangeManagerInterface changeManager) {
		this.changeManager = changeManager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.changeManager.makeChange();
	}

	public ChangeManagerInterface getChangeManager() {
		return changeManager;
	}
}
