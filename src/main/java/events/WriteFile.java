package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import main.MainFrame;
import panels.PathPanel;

public class WriteFile implements ActionListener {

	private JTextArea area;

	public void actionPerformed(ActionEvent e) {

		area = MainFrame.mainPanel.textAreaPanel.textArea;
		String path = MainFrame.mainPanel.namePanel.textField.getText();
		try {
			if (!path.equals("") && new File(path).isFile()) {
				areaInFile(area, path);
				PathPanel.sayFileSaved();
			} else {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Save in file");
				if (ret == JFileChooser.APPROVE_OPTION) {

					path = fileopen.getSelectedFile().getAbsolutePath();

					areaInFile(area, path);

					MainFrame.mainPanel.namePanel.textField.setText(path);
					PathPanel.sayFileSaved();
				}
			}
		} catch (NoFileToWriteException ex) {
			System.out.println("No file to write");
			throw new RuntimeException(ex);

		}
	}

	private void areaInFile(JTextArea area, String path) throws NoFileToWriteException {
		/*
		 * TODO 1: Obsluz pojawiajacy sie tutaj wyjatek. Wyswietl blad: a)
		 * wersja trudniejsza: utworz popup/wypisz blad jako label w oknie b)
		 * wersja latwiejsza: wyswietl blad w konsoli
		 */
		FileWriter writer;
		try {
			writer = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(writer);
			area.write(bw);
			bw.close();
		} catch (IOException e) {
			throw new NoFileToWriteException();
		}

	}

}
