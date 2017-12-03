package aiss.model.repository;

import aiss.controller.DriveFileListController;
import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;
import aiss.utility.OAuthServiceConfiguration;

public class DriveRepository {

	// Direccion necesaria para generar el token de drive:
	// https://developers.google.com/oauthplayground/?code=4/ChhEuAj8HP4DGm1bKTcYLUf41C7Eg2OrkOlWE-mltuI#
	
	private static DriveRepository instance = null;
	public static GoogleDriveResource gd = new GoogleDriveResource(DriveFileListController.getOauthToken());
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
	public FileItem getFile(String id) {
		return gd.getFile(id);
	}
	public String getFileContent(FileItem item) {
		return gd.getFileContent(item);
	}
	public String newFiles(String file, String content) {
		FileItem fileItem = new FileItem();
		fileItem.setTitle(file + ".txt");
		fileItem.setMimeType("text/plain");
		String id = gd.insertFile(fileItem, content); 
		return id;
	}
	public boolean updateFile(String id, String content) {	
		return gd.updateFileContent(id, content);
	}

	public boolean deleteFile(String id) {
		return gd.deleteFile(id);
	}
}
