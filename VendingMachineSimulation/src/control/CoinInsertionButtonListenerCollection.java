package control;

public class CoinInsertionButtonListenerCollection {

	private final PennyButtonListener pennyButtonListener;
	private final NickelButtonListener nickelButtonListener;
	private final DimeButtonListener dimeButtonListner;
	private final QuarterButtonListener quarterButtonListener;
	private final SlugButtonListener slugButtonListener;

	public CoinInsertionButtonListenerCollection(PennyButtonListener pennyButtonListener,
			NickelButtonListener nickelButtonListener, DimeButtonListener dimeButtonListener,
			QuarterButtonListener quarterButtonListener, SlugButtonListener slugButtonListener) {
		this.pennyButtonListener = pennyButtonListener;
		this.nickelButtonListener = nickelButtonListener;
		this.dimeButtonListner = dimeButtonListener;
		this.quarterButtonListener = quarterButtonListener;
		this.slugButtonListener = slugButtonListener;
	}

	public PennyButtonListener getPennyButtonListener() {
		return this.pennyButtonListener;
	}

	public NickelButtonListener getNickelButtonListener() {
		return this.nickelButtonListener;
	}

	public DimeButtonListener getDimeButtonListener() {
		return this.dimeButtonListner;
	}

	public QuarterButtonListener getQuarterButtonListener() {
		return this.quarterButtonListener;
	}

	public SlugButtonListener getSlugButtonListener() {
		return this.slugButtonListener;
	}
}
