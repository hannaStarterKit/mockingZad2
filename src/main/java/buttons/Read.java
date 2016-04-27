package buttons;

import javax.swing.JButton;

import events.ReadFile;

public class Read extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Read (String text) {
		this.addActionListener(new ReadFile());
		this.setText(text);
	}
}
