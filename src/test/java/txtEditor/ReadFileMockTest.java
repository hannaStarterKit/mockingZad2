package txtEditor;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import events.NoFileToReadException;
import events.ReadFile;
import javassist.tools.reflect.CannotCreateException;

public class ReadFileMockTest {

	/**
	 * TODO 4: Przetestuj metode ReadFile.fileInArea(JTextArea, String).
	 * Sprawdz, czy zwraca ona wyjatek zaleznie od danych wejsciowych. Mozesz
	 * uzyc mockow lub danych przygotowanych.
	 * 
	 * @return
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException
	 */
	File createdFile;
	File createdFolderSucces;
	File createdFolderThrow;
	ReadFile raedFile = new ReadFile();
	JTextArea area = new JTextArea();

	@Before
	public void PrepareForTest() throws IOException {
		createdFile = folder.newFile("good.txt");
		createdFolderSucces = folder.newFolder("goodSubFolder");
		createdFolderThrow = folder.newFolder("badSubFolder");
		raedFile = new ReadFile();
		area = new JTextArea();
	}

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void fileInAreaSuccesTest() throws FileNotFoundException {
		//given
		
		//when
		try {
			raedFile.fileInArea(area, createdFile.getPath());
		} catch (NoFileToReadException e) {
			//then
			assertTrue(false);
		}
		assertTrue(true);
	}

	@Test(expected = NoFileToReadException.class)
	public void fileInAreaThrowTest() throws NoFileToReadException {
		// given
		File badFile = new File(createdFolderThrow.getAbsolutePath()+"\bad.txt");

		//when
		raedFile.fileInArea(area, badFile.getPath());
	}

	/*
	 * TODO 5: Przetestuj metode actionPerformed w klasie ReadFile. Chcemy
	 * sprawic, by PathPanel.sayFileOpened() nie zostalo wywolane. Utworz mock
	 * obiektu ActionEvent i wywolaj metode actionPerformed. Zamockuj tez
	 * odpowiednio TextField.getText(), tak by if w metodzie actionPerformed
	 * zwrocil true. Nie zapomnij o mocku dla metody areaInFile tak, by metoda
	 * zwrocila wyjatek.
	 */
}
