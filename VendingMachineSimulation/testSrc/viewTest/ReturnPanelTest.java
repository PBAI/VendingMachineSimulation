package viewTest;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import junit.framework.TestCase;
import view.ReturnPanel;

public class ReturnPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, ReturnPanel.class.getSuperclass());
	}

	public void testHasFlowLayout() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		assertSame(FlowLayout.class, returnPanel.getLayout().getClass());
	}

	public void testPanelName() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		assertEquals("ReturnPanel", returnPanel.getName());
	}

	public void testHasCoinReturnLabel() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		assertEquals(JLabel.class, returnPanel.getComponent(0).getClass());

		JLabel returnLabel = (JLabel) returnPanel.getComponent(0);
		String expectedLabelText = "Coin Return";
		assertEquals(expectedLabelText, returnLabel.getText());
	}

	public void testHasFiveCoinReturnTextFields() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		Component[] components = returnPanel.getComponents();
		assertEquals(7, components.length);
		assertSame(JTextField.class, components[1].getClass());
		assertSame(JTextField.class, components[2].getClass());
		assertSame(JTextField.class, components[3].getClass());
		assertSame(JTextField.class, components[4].getClass());
		assertSame(JTextField.class, components[5].getClass());

		ArrayList<JTextField> textFieldsAsList = getTextFieldsAsList(returnPanel);
		assertEquals(5, textFieldsAsList.size());
		assertEquals("PennyReturnTextField", textFieldsAsList.get(0).getName());
		assertEquals("NickelReturnTextField", textFieldsAsList.get(1).getName());
		assertEquals("DimeReturnTextField", textFieldsAsList.get(2).getName());
		assertEquals("QuarterReturnTextField", textFieldsAsList.get(3).getName());
		assertEquals("SlugReturnTextField", textFieldsAsList.get(4).getName());

		for (JTextField jTextField : textFieldsAsList) {
			int expectedColumns = 20;
			assertEquals(expectedColumns, jTextField.getColumns());
		}
	}

	public void testHasReturnButton() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		assertSame(JButton.class, returnPanel.getComponent(6).getClass());
		JButton button = (JButton) returnPanel.getComponent(6);
		String expectedName = "ReturnButton";
		assertEquals(expectedName, button.getName());

		String expectedButtonText = "Return";
		assertEquals(expectedButtonText, button.getText());
	}

	public void testShowPennyTextFieldUpdatedAmount() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		String initialText = "Pennies: ";
		assertEquals(initialText, returnPanel.getPennyTextField().getText());
		int amountToDisplay = 2;
		returnPanel.showPennyTextFieldUpdatedAmount(amountToDisplay);
		String expectedTextFieldDisplayWithPrefix = initialText + amountToDisplay;
		assertEquals(expectedTextFieldDisplayWithPrefix, returnPanel.getPennyTextField().getText());
	}

	public void testShowNickelTextFieldUpdatedAmount() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		String initialText = "Nickels: ";
		assertEquals(initialText, returnPanel.getNickelTextField().getText());
		int amountToDisplay = 4;
		returnPanel.showNickelTextFieldUpdatedAmount(amountToDisplay);
		String expectedTextFieldDisplayWithPrefix = initialText + amountToDisplay;
		assertEquals(expectedTextFieldDisplayWithPrefix, returnPanel.getNickelTextField().getText());
	}

	public void testShowDimeTextFieldUpdatedAmount() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		String initialText = "Dimes: ";
		assertEquals(initialText, returnPanel.getDimeTextField().getText());
		int amountToDisplay = 3;
		returnPanel.showDimeTextFieldUpdatedAmount(amountToDisplay);
		String expectedTextFieldDisplayWithPrefix = initialText + amountToDisplay;
		assertEquals(expectedTextFieldDisplayWithPrefix, returnPanel.getDimeTextField().getText());
	}

	public void testShowQuarterTextFieldUpdatedAmount() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		String initialText = "Quarters: ";
		assertEquals(initialText, returnPanel.getQuarterTextField().getText());
		int amountToDisplay = 3;
		returnPanel.showQuarterTextFieldUpdatedAmount(amountToDisplay);
		String expectedTextFieldDisplayWithPrefix = initialText + amountToDisplay;
		assertEquals(expectedTextFieldDisplayWithPrefix, returnPanel.getQuarterTextField()
				.getText());
	}

	public void testShowSlugTextFieldUpdatedAmount() throws Exception {
		ReturnPanel returnPanel = new ReturnPanel();
		String initialText = "Slugs: ";
		assertEquals(initialText, returnPanel.getSlugTextField().getText());
		int amountToDisplay = 7;
		returnPanel.showSlugTextFieldUpdatedAmount(amountToDisplay);
		String expectedTextFieldDisplayWithPrefix = initialText + amountToDisplay;
		assertEquals(expectedTextFieldDisplayWithPrefix, returnPanel.getSlugTextField().getText());
	}

	private ArrayList<JTextField> getTextFieldsAsList(JPanel returnPanel) {
		ArrayList<JTextField> textFields = new ArrayList<JTextField>();
		Component[] components = returnPanel.getComponents();
		for (int i = 1; i < components.length - 1; i++) {
			JTextField textField = (JTextField) components[i];
			textFields.add(textField);
		}
		return textFields;
	}
}
