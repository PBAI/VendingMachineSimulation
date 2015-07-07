package viewTest;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import junit.framework.TestCase;
import view.UserCommunicationDisplayPanel;

public class UserCommunicationDisplayPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, UserCommunicationDisplayPanel.class.getSuperclass());
	}

	public void testOpacity() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		assertTrue(panel.isOpaque());
	}

	public void testPanelName() throws Exception {
		UserCommunicationDisplayPanel userCommunicationDisplayPanel = new UserCommunicationDisplayPanel();
		String expectedPanelName = "UserCommunicationDisplayPanel";
		assertEquals(expectedPanelName, userCommunicationDisplayPanel.getName());
	}

	public void testUsesFlowLayout() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		assertSame(FlowLayout.class, panel.getLayout().getClass());
	}

	public void testWhenPanelConstructedHasTextFieldWithInsertCoinsMessage() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		assertSame(JTextField.class, panel.getComponent(0).getClass());
		JTextField textField = (JTextField) panel.getComponent(0);
		String expectedInsertCoinsText = "INSERT COIN";
		assertEquals(expectedInsertCoinsText, textField.getText());
	}

	public void testSetInsertCoinsText() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		panel.setInsertCoinsText();
		JTextField textField = (JTextField) panel.getComponent(0);
		String expectedInsertCoinsText = "INSERT COIN";
		assertEquals(expectedInsertCoinsText, textField.getText());
	}

	public void testSetThankYouText() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		panel.setThankYouText();
		JTextField textField = (JTextField) panel.getComponent(0);
		String expectedThankYouText = "THANK YOU!";
		assertEquals(expectedThankYouText, textField.getText());
	}

	public void testSetPriceText() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		String priceText = "2.25";
		panel.setPriceText(priceText);
		JTextField textField = (JTextField) panel.getComponent(0);
		String expectedPriceText = "Price: " + priceText;
		assertEquals(expectedPriceText, textField.getText());
	}

	public void testSetSoldOutText() throws Exception {
		UserCommunicationDisplayPanel panel = new UserCommunicationDisplayPanel();
		panel.setSoldOutText();
		JTextField textField = (JTextField) panel.getComponent(0);
		String expectedSoldOutText = "SOLD OUT";
		assertEquals(expectedSoldOutText, textField.getText());
	}
}
