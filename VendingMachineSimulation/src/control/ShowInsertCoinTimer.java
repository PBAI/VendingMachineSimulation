package control;

import javax.swing.Timer;

public class ShowInsertCoinTimer {

	private final Timer actualTimer;
	private final int delayInMilliseconds;
	private final InsertCoinDisplayUpdateActionListener listenerForTimer;

	public ShowInsertCoinTimer(int delayInMilliseconds,
			InsertCoinDisplayUpdateActionListener listenerForTimer) {
		this.delayInMilliseconds = delayInMilliseconds;
		this.listenerForTimer = listenerForTimer;
		this.actualTimer = new Timer(this.delayInMilliseconds, this.listenerForTimer);
		this.actualTimer.setRepeats(false);
	}

	public int getDelay() {
		return this.delayInMilliseconds;
	}

	public InsertCoinDisplayUpdateActionListener getListener() {
		return this.listenerForTimer;
	}

	public Timer getActualTimer() {
		return this.actualTimer;
	}

	public boolean getRepeats() {
		return this.actualTimer.isRepeats();
	}

	public void startTimer() {
		this.actualTimer.start();
	}
}
