package viewTest;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import junit.framework.TestCase;
import view.CoinReturnDisplayPanel;

public class CoinReturnDisplayPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, CoinReturnDisplayPanel.class.getSuperclass());
	}

	public void testPanelName() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		String expectedPanelName = "CoinReturnDisplayPanel";
		assertEquals(expectedPanelName, panel.getName());
	}

	public void testUsesFlowLayout() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		assertSame(FlowLayout.class, panel.getLayout().getClass());
	}

	public void testHasChangeLabel() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		assertSame(panel.getChangeLabel(), panel.getComponent(0));
		String expectedLabelText = "Change:";
		assertEquals(expectedLabelText, panel.getChangeLabel().getText());
	}

	public void testHasChangeDisplayTextField() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		assertSame(panel.getChangeDisplayTextField(), panel.getComponent(1));
	}

	public void testWhenConstructedHasAChangeDisplayOfZero() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		assertEquals("0.00", panel.getChangeDisplayTextField().getText());
	}

	public void testShowValidChangeAmount() throws Exception {
		CoinReturnDisplayPanel panel = new CoinReturnDisplayPanel();
		String expectedValidChange = "1.25";
		panel.showValidChangeAmount(expectedValidChange);
		assertEquals(expectedValidChange, panel.getChangeDisplayTextField().getText());
	}
}
