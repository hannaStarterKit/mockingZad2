package panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class TextAreaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JTextArea textArea = new JTextArea();
	
	public TextAreaPanel() {
		textArea.setBorder(new LineBorder(Color.GRAY));
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setRows(25);
		textArea.setColumns(50);
		
		add(scroll);
	}
}
