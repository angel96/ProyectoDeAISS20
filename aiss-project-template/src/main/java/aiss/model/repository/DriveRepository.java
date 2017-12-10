package aiss.model.repository;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class DriveRepository{

	// Direccion necesaria para generar el token de drive:
	// https://developers.google.com/oauthplayground/?code=4/ChhEuAj8HP4DGm1bKTcYLUf41C7Eg2OrkOlWE-mltuI#

	
	

	private static DriveRepository instance = null;
	
			;
	
	public static DriveRepository getInstance() {
		if (instance == null) {
			instance = new DriveRepository();
			instance.init("");
		}
		return instance;
	}

	public Files init(String token) {
		
		return new GoogleDriveResource(token).getFiles();
	}
	
	public FileItem getFile(String id ,String token) {
		return new GoogleDriveResource(token).getFile(id);
	}
	public String getFileContent(FileItem item ,String token) {
		return new GoogleDriveResource(token).getFileContent(item);
	}
	public String newFiles(String file, String content ,String token) {
		FileItem fileItem = new FileItem();
		fileItem.setTitle(file + ".txt");
		fileItem.setMimeType("text/plain");
		String id = new GoogleDriveResource(token).insertFile(fileItem, content); 
		return id;
	}
	public boolean updateFile(String id, String content ,String token) {	
		return new GoogleDriveResource(token).updateFileContent(id, content);
	}

	public boolean deleteFile(String id ,String token) {
		return new GoogleDriveResource(token).deleteFile(id);
	}
}
