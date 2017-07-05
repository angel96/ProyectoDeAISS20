package aiss.model.resources;

import java.util.Map;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.Header;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;

public class GoogleDriveResource {
	private static final Logger log=Logger.getLogger(GoogleDriveResource.class.getName());
	//TODO: ADAPTAR RESOURCE
	private String uri = "https://www.googleapis.com/drive/v2/files";
	private String access_token;
	private String uri_upload = "https://www.googleapis.com/upload/drive/v2/files";

	public GoogleDriveResource(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 
	 * @return Files
	 */
	
	public String insertFile(FileItem file, String content) {

		ClientResource cr = null;
		String newId = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			FileItem newFile = cr.post(file, FileItem.class);
			newId = newFile.getId();
			cr = new ClientResource(uri_upload + "/" + newId + "?uploadType=media&access_token=" + access_token);
			Map<String, Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "text/plain");
			cr.put(content);
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return newId;
	}

	
}
