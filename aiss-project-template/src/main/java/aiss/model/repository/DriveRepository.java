package aiss.model.repository;

import java.io.File;
import java.util.List;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class DriveRepository {

	// POST A DRIVE
	// UpdateElement Drive
	// Direccion necesaria para generar el token de drive:
	// https://developers.google.com/oauthplayground/?code=4/ChhEuAj8HP4DGm1bKTcYLUf41C7Eg2OrkOlWE-mltuI#
	// Atributo para el GET de Drive
	private final static String OAUTH_TOKEN = "ya29.Glu_BBbZQAU_LpLmChlCr5lJX3Dcuy6a0hlSWoq98a4-LnO_srpVFgIY8jxL2cp62l-VW-_k6nTsNeI3-WPAPW5jLGqaJMQotwtH0Uyt49Qto0hQeNoM4gnK_y74";
	private static DriveRepository instance = null;
	private GoogleDriveResource gd = new GoogleDriveResource(OAUTH_TOKEN);
	private FileItem file = new FileItem();
	private String id; // Puesto aqui para poder usar el update luego

	public static DriveRepository getInstance() {
		if (instance == null) {
			instance = new DriveRepository();
			instance.init();
			instance.newFiles();
		}
		return instance;
	}

	public Files init() {

		return gd.getFiles();
	}

	public boolean newFiles() {
		String title = "prueba";
		file.setTitle(title + ".txt");
		file.setMimeType("text/plain");
		String content = "probando junit4";
		id = gd.insertFile(file, content);
		return id == "" || id == null ? false : true;
	}

	public boolean updateFile() {
		String contentFile = "probando update";
		boolean var = gd.updateFileContent(id, contentFile);
		return var;
	}

	public boolean deleteFile() {
		return gd.deleteFile(id);
	}
}
