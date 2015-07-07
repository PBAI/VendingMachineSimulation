package startupTest;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JPanel;

import junit.framework.TestCase;
import startup.ViewControlConnector;
import view.VendingWindow;
import control.CoinInsertionButtonListenerCollection;
import control.DimeButtonListener;
import control.EmptyChangeSlotButtonListener;
import control.NickelButtonListener;
import control.PennyButtonListener;
import control.QuarterButtonListener;
import control.ReturnButtonListener;
import control.SlugButtonListener;
import control.VendingButtonListener;
import controlTest.MockChangeManager;
import controlTest.MockCoinInsertionManager;
import controlTest.MockVendingController;

public class ViewControlConnectorTest extends TestCase {

	public void testGetters() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));
		EmptyChangeSlotButtonListener emptyChangeSlotButtonListener = new EmptyChangeSlotButtonListener(
				new MockChangeManager());
		ReturnButtonListener returnButtonListener = new ReturnButtonListener(
				new MockChangeManager());
		MockVendingController vendingController = new MockVendingController();

		ViewControlConnector viewControlConnector = new ViewControlConnector(
				coinInsertionButtonListeners, emptyChangeSlotButtonListener, returnButtonListener,
				vendingWindow, vendingController);

		assertSame(vendingController, viewControlConnector.getVendingController());
		assertSame(VendingButtonListener.class, viewControlConnector.getVendingButtonListener()
				.getClass());
		VendingButtonListener vendingButtonListener = viewControlConnector
				.getVendingButtonListener();
		assertSame(vendingController, vendingButtonListener.getVendingController());
		assertSame(coinInsertionButtonListeners,
				viewControlConnector.getCoinInsertionButtonListeners());
		assertSame(emptyChangeSlotButtonListener,
				viewControlConnector.getEmptyChangeSlotButtonListener());
		assertSame(returnButtonListener, viewControlConnector.getReturnButtonListener());
		assertSame(vendingWindow, viewControlConnector.getVendingWindow());
	}

	public void testConnectProductSelectionButtonsToButtonListeners_ConnectsButtonAListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton buttonA = getButtonFromSubPanel(vendingWindow, 0, 0, 0);

		ViewControlConnector connector = new ViewControlConnector(
				new CoinInsertionButtonListenerCollection(new PennyButtonListener(
						new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager())), new EmptyChangeSlotButtonListener(
						new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, buttonA.getActionListeners().length);
		connector.connectProductSelectionButtonsToVendingButtonListener();
		assertEquals(1, buttonA.getActionListeners().length);
		assertSame(connector.getVendingButtonListener(), buttonA.getActionListeners()[0]);
	}

	public void testConnectProductSelectionButtonsToButtonListeners_ConnectsButtonBListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton buttonB = getButtonFromSubPanel(vendingWindow, 0, 1, 0);

		ViewControlConnector connector = new ViewControlConnector(
				new CoinInsertionButtonListenerCollection(new PennyButtonListener(
						new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager())), new EmptyChangeSlotButtonListener(
						new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, buttonB.getActionListeners().length);
		connector.connectProductSelectionButtonsToVendingButtonListener();
		assertEquals(1, buttonB.getActionListeners().length);
		assertSame(connector.getVendingButtonListener(), buttonB.getActionListeners()[0]);
	}

	public void testConnectProductSelectionButtonsToButtonListeners_ConnectsButtonCListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton buttonC = getButtonFromSubPanel(vendingWindow, 0, 2, 0);

		ViewControlConnector connector = new ViewControlConnector(
				new CoinInsertionButtonListenerCollection(new PennyButtonListener(
						new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager())), new EmptyChangeSlotButtonListener(
						new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, buttonC.getActionListeners().length);
		connector.connectProductSelectionButtonsToVendingButtonListener();

		assertEquals(1, buttonC.getActionListeners().length);
		assertSame(connector.getVendingButtonListener(), buttonC.getActionListeners()[0]);
	}

	public void testConnectCoinInsertionButtonsToButtonListeners_ConnectsPennyButtonListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton pennyButton = getButtonFromSubPanel(vendingWindow, 1, 2, 0);

		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, pennyButton.getActionListeners().length);
		connector.connectCoinInsertionButtonsToButtonListeners();

		assertEquals(1, pennyButton.getActionListeners().length);
		assertSame(coinInsertionButtonListeners.getPennyButtonListener(),
				pennyButton.getActionListeners()[0]);
	}

	public void testConnectCoinInsertionButtonsToButtonListeners_ConnectsNickelButtonListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton nickelButton = getButtonFromSubPanel(vendingWindow, 1, 2, 1);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, nickelButton.getActionListeners().length);
		connector.connectCoinInsertionButtonsToButtonListeners();

		assertEquals(1, nickelButton.getActionListeners().length);
		assertSame(coinInsertionButtonListeners.getNickelButtonListener(),
				nickelButton.getActionListeners()[0]);
	}

	public void testConnectCoinInsertionButtonsToButtonListeners_ConnectsDimeButtonListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton dimeButton = getButtonFromSubPanel(vendingWindow, 1, 2, 2);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, dimeButton.getActionListeners().length);
		connector.connectCoinInsertionButtonsToButtonListeners();

		assertEquals(1, dimeButton.getActionListeners().length);
		assertSame(coinInsertionButtonListeners.getDimeButtonListener(),
				dimeButton.getActionListeners()[0]);
	}

	public void testConnectCoinInsertionButtonsToButtonListeners_ConnectsQuarterButtonListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton quarterButton = getButtonFromSubPanel(vendingWindow, 1, 2, 3);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, quarterButton.getActionListeners().length);
		connector.connectCoinInsertionButtonsToButtonListeners();

		assertEquals(1, quarterButton.getActionListeners().length);
		assertSame(coinInsertionButtonListeners.getQuarterButtonListener(),
				quarterButton.getActionListeners()[0]);
	}

	public void testConnectCoinInsertionButtonsToButtonListeners_ConnectsSlugButtonListener()
			throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton slugButton = getButtonFromSubPanel(vendingWindow, 1, 2, 4);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		assertEquals(0, slugButton.getActionListeners().length);
		connector.connectCoinInsertionButtonsToButtonListeners();

		assertEquals(1, slugButton.getActionListeners().length);
		assertSame(coinInsertionButtonListeners.getSlugButtonListener(),
				slugButton.getActionListeners()[0]);
	}

	public void testConnectEmptyChangeSlotButtonListenerToButton() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton emptyChangeSlotButton = getButtonFromSubPanel(vendingWindow, 2, 1, 0);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()),
				new ReturnButtonListener(new MockChangeManager()), vendingWindow,
				new MockVendingController());

		connector.connectEmptyChangeSlotButtonToListener();
		assertEquals(1, emptyChangeSlotButton.getActionListeners().length);
		assertSame(EmptyChangeSlotButtonListener.class,
				emptyChangeSlotButton.getActionListeners()[0].getClass());
	}

	public void testConnectReturnButtonListenerToButton() throws Exception {
		VendingWindow vendingWindow = new VendingWindow();
		JButton returnButton = getButtonFromSubPanel(vendingWindow, 2, 2, 6);
		CoinInsertionButtonListenerCollection coinInsertionButtonListeners = new CoinInsertionButtonListenerCollection(
				new PennyButtonListener(new MockCoinInsertionManager()), new NickelButtonListener(
						new MockCoinInsertionManager()), new DimeButtonListener(
						new MockCoinInsertionManager()), new QuarterButtonListener(
						new MockCoinInsertionManager()), new SlugButtonListener(
						new MockCoinInsertionManager()));

		ReturnButtonListener returnButtonListener = new ReturnButtonListener(
				new MockChangeManager());
		ViewControlConnector connector = new ViewControlConnector(coinInsertionButtonListeners,
				new EmptyChangeSlotButtonListener(new MockChangeManager()), returnButtonListener,
				vendingWindow, new MockVendingController());

		connector.connectReturnButtonToListener();
		assertEquals(1, returnButton.getActionListeners().length);
		assertSame(ReturnButtonListener.class, returnButton.getActionListeners()[0].getClass());
		assertSame(returnButtonListener, returnButton.getActionListeners()[0]);
	}

	private JButton getButtonFromSubPanel(VendingWindow vendingWindow, int subPanelNumber,
			int subPanelComponentNumber, int buttonNumber) {
		Container contentPane = vendingWindow.getContentPane();
		JPanel subPanel = (JPanel) contentPane.getComponent(subPanelNumber);
		JPanel buttonPanel = (JPanel) subPanel.getComponent(subPanelComponentNumber);
		JButton button = (JButton) buttonPanel.getComponent(buttonNumber);
		return button;
	}
}
