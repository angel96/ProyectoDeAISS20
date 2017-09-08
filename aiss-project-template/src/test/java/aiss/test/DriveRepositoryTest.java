package aiss.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.repository.DriveRepository;

@RunWith(DescriptionSorterRunner.class)
public class DriveRepositoryTest {

	private DriveRepository rep;
	private Files ls;
	private FileItem item = new FileItem();
	private String id;

	@Before
	public void setUp() throws Exception {
		rep = DriveRepository.getInstance();
		/*
		 * rep.init() --> Devuelve una lista de objetos ya consultados
		 */
		ls = rep.init();
	}

	@Test
	public void test01GetFiles() {
		assertNotNull("Comprobando que se devuelven bien los ficheros con el token del repositorio", ls);
	}

	@Test
	public void test02NewFile() {
		
		String title = "prueba";
		item.setTitle(title + ".txt");
		item.setMimeType("text/plain");
		String content = "probando junit4";
		id = rep.newFiles(item, content);
		assertNotNull(id);
	}

	@Test
	public void test03UpdateFile() {
		boolean var = rep.updateFile(); 
		assertEquals(var, true);
	}

	@Test
	public void test04DeleteFile() {
		boolean var = rep.deleteFile();
		assertEquals(var, true);
	}
}
