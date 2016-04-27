package panels;

import javax.swing.JPanel;

import buttons.Delete;
import buttons.Read;
import buttons.Rename;
import buttons.Write;

public class ButtonsPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Read open = new Read("OPEN");
	public Write save = new Write("SAVE");
	public Rename rename = new Rename("RENAME");
	public Delete delete = new Delete("DELETE");

	public ButtonsPanel() {
		add(open);
		add(save);
		add(rename);
		add(delete);
	}
}
