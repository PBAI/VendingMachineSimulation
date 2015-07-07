package viewTest;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import junit.framework.TestCase;
import view.EmptyChangeSlotButtonPanel;

public class EmptyChangeSlotButtonPanelTest extends TestCase {

	public void testExtendsJPanel() throws Exception {
		assertSame(JPanel.class, EmptyChangeSlotButtonPanel.class.getSuperclass());
	}

	public void testUsesFlowLayout() throws Exception {
		EmptyChangeSlotButtonPanel panel = new EmptyChangeSlotButtonPanel();
		assertSame(FlowLayout.class, panel.getLayout().getClass());
	}

	public void testHasEmptyChangeSlotButton() throws Exception {
		EmptyChangeSlotButtonPanel panel = new EmptyChangeSlotButtonPanel();
		assertSame(JButton.class, panel.getComponent(0).getClass());

		JButton button = (JButton) panel.getComponent(0);
		String expectedButtonName = "EmptyChangeSlotButton";
		assertEquals(expectedButtonName, button.getName());

		String expectedButtonText = "Collect Change";
		assertEquals(expectedButtonText, button.getText());

		assertSame(panel.getEmptyChangeSlotButton(), panel.getComponent(0));
	}
}
