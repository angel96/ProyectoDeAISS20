package aiss.model.repository;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class DriveRepository {

	// Direccion necesaria para generar el token de drive:
	// https://developers.google.com/oauthplayground/?code=4/ChhEuAj8HP4DGm1bKTcYLUf41C7Eg2OrkOlWE-mltuI#

	private final static String OAUTH_TOKEN = "ya29.GlvABFhOtuVpYry4HQAfT2v-LcvnKvq0la6R2TF3pOD5FSTKMYUBUYWjHUet5lLRY7TEMvx1wjU-wOOC76q5OwkaANX91rOXA34CArZOMKJOYRPzkKoROmYyXGI4";
	private static DriveRepository instance = null;
	public static GoogleDriveResource gd = new GoogleDriveResource(OAUTH_TOKEN);
	private String id;
	public static DriveRepository getInstance() {
		if (instance == null) {
			instance = new DriveRepository();
			instance.init();
		}
		return instance;
	}

	public Files init() {

		return gd.getFiles();
	}

	public String newFiles(FileItem file, String content) {
		String title = "prueba";
		file.setTitle(title + ".txt");
		file.setMimeType("text/plain");
		id = gd.insertFile(file, content);
		return id;
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
