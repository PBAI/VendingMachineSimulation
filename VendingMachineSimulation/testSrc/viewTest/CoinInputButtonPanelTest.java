package viewTest;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import junit.framework.TestCase;
import view.CoinInputButtonPanel;

public class CoinInputButtonPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, CoinInputButtonPanel.class.getSuperclass());
	}

	public void testAllComponentsAreJButtons() {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		for (Component component : panel.getComponents()) {
			assertSame(JButton.class, component.getClass());
		}
	}

	public void testPanelName() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		assertEquals("CoinInputButtonPanel", panel.getName());
	}

	public void testUsesFlowLayout() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		assertSame(FlowLayout.class, panel.getLayout().getClass());
	}

	public void testHasAddPennyButton() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		JButton button = (JButton) panel.getComponent(0);

		String expectedButtonName = "PennyButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Add Penny";
		assertEquals(expectedButtonText, button.getText());
	}

	public void testHasAddNickelButton() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		JButton button = (JButton) panel.getComponent(1);

		String expectedButtonName = "NickelButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Add Nickel";
		assertEquals(expectedButtonText, button.getText());
	}

	public void testHasAddDimeButton() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		JButton button = (JButton) panel.getComponent(2);

		String expectedButtonName = "DimeButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Add Dime";
		assertEquals(expectedButtonText, button.getText());
	}

	public void testHasAddQuarterButton() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		JButton button = (JButton) panel.getComponent(3);

		String expectedButtonName = "QuarterButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Add Quarter";
		assertEquals(expectedButtonText, button.getText());
	}

	public void testHasAddSlugButton() throws Exception {
		CoinInputButtonPanel panel = new CoinInputButtonPanel();
		JButton button = (JButton) panel.getComponent(4);

		String expectedButtonName = "SlugButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Add Slug";
		assertEquals(expectedButtonText, button.getText());
	}
}
