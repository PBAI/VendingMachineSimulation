package controlTest;

import control.InsertCoinDisplayUpdateActionListener;
import control.ShowInsertCoinTimer;
import junit.framework.TestCase;
import viewTest.MockVendingWindow;

public class ShowInsertCoinTimerTest extends TestCase {

	public void testGetDelay() throws Exception {
		int delayInMilliseconds = 2000;
		ShowInsertCoinTimer showInsertCoinTimer = new ShowInsertCoinTimer(delayInMilliseconds,
				new InsertCoinDisplayUpdateActionListener(new MockVendingWindow()));
		assertEquals(delayInMilliseconds, showInsertCoinTimer.getDelay());
	}

	public void testGetListener() throws Exception {
		InsertCoinDisplayUpdateActionListener listenerForTimer = new InsertCoinDisplayUpdateActionListener(
				new MockVendingWindow());
		ShowInsertCoinTimer showInsertCoinTimer = new ShowInsertCoinTimer(100, listenerForTimer);
		assertSame(listenerForTimer, showInsertCoinTimer.getListener());
	}

	public void testGetActualTimer() throws Exception {
		int delayInMilliseconds = 344;
		InsertCoinDisplayUpdateActionListener listenerForTimer = new InsertCoinDisplayUpdateActionListener(
				new MockVendingWindow());
		ShowInsertCoinTimer showInsertCoinTimer = new ShowInsertCoinTimer(delayInMilliseconds,
				listenerForTimer);
		assertEquals(delayInMilliseconds, showInsertCoinTimer.getActualTimer().getDelay());
		assertSame(listenerForTimer, showInsertCoinTimer.getActualTimer().getActionListeners()[0]);
	}

	public void testTimerShouldRepeatIsFalse() throws Exception {
		ShowInsertCoinTimer showInsertCoinTimer = new ShowInsertCoinTimer(434,
				new InsertCoinDisplayUpdateActionListener(new MockVendingWindow()));
		assertFalse(showInsertCoinTimer.getRepeats());
	}

	public void testStartTimer() throws Exception {
		ShowInsertCoinTimer timer = new ShowInsertCoinTimer(50,
				new InsertCoinDisplayUpdateActionListener(new MockVendingWindow()));
		timer.startTimer();
		assertTrue(timer.getActualTimer().isRunning());
	}
}
