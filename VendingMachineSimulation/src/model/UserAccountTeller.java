package model;

import control.ChangeManagerInterface;

public class UserAccountTeller {

	private final UserBalanceInterface userBalance;
	private final ChangeManagerInterface changeManager;

	public UserAccountTeller(UserBalanceInterface userBalance, ChangeManagerInterface changeManager) {
		this.userBalance = userBalance;
		this.changeManager = changeManager;
	}

	public UserBalanceInterface getUserBalance() {
		return this.userBalance;
	}

	public ChangeManagerInterface getChangeManager() {
		return this.changeManager;
	}

}
