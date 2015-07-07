package viewTest;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import junit.framework.TestCase;
import view.UserBalanceDisplayPanel;

public class UserBalanceDisplayPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, UserBalanceDisplayPanel.class.getSuperclass());
	}

	public void testIsOpaque() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		assertTrue(panel.isOpaque());
	}

	public void testPanelName() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		assertEquals("UserBalanceDisplayPanel", panel.getName());
	}

	public void testUsesFlowLayout() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		assertSame(FlowLayout.class, panel.getLayout().getClass());
	}

	public void testHasCorrectLabel() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		assertSame(JLabel.class, panel.getComponent(1).getClass());
		JLabel label = (JLabel) panel.getComponent(1);
		String expectedLabelText = "Your Balance";
		assertEquals(expectedLabelText, label.getText());
	}

	public void testHasBalanceTextField() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		assertSame(JTextField.class, panel.getComponent(0).getClass());
		JTextField textField = panel.getBalanceDisplayTextField();
		String expectedInitialTextFieldText = "0.00";
		assertEquals(expectedInitialTextFieldText, textField.getText());
	}

	public void testShowUpdatedBalance() throws Exception {
		UserBalanceDisplayPanel panel = new UserBalanceDisplayPanel();
		String balanceToDisplay = "5.65";
		panel.showUpdatedBalance(balanceToDisplay);
		assertEquals(balanceToDisplay, panel.getBalanceDisplayTextField().getText());
	}
}
