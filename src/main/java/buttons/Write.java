package buttons;

import javax.swing.JButton;

import events.WriteFile;

public class Write extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Write (String text) {
		this.addActionListener(new WriteFile());
		this.setText(text);
	}
}
