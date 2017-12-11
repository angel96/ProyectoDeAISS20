package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.google.drive.FileItem;
import aiss.model.repository.DriveRepository;

@Path("/drive")
public class GoogleDriveSingle {

	/**
	 * Singleton
	 * 
	 * @return
	 */
	private static GoogleDriveSingle _instance = null;
	DriveRepository repository;

	private GoogleDriveSingle() {
		repository = DriveRepository.getInstance();
	}

	public static GoogleDriveSingle getInstance() {

		if (_instance == null) {
			_instance = new GoogleDriveSingle();
		}
		return _instance;
	}

	@GET
	@Path("/all")
	@Produces("application/json")
	public Collection<FileItem> getAll(@QueryParam("oauth") String oauth, @QueryParam("title") String title) {
		List<FileItem> res = new ArrayList<>();
		for(FileItem file : repository.init(oauth).getItems()) {
			if(title==null || title.equals("") || title.equals(file.getTitle())) {
				res.add(file);
			}
		}
		return res;
	}

	// ESTE SI
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public Response addFile(@Context UriInfo uriInfo, @QueryParam("filename") String file, String content, @QueryParam("oauth") String oauth)
	{
		
		if (file == null) {
			return Response.status(400).entity("Fichero nulo!!!").build();
		}

		if (content == null || content == "") {
			return Response.status(400).entity("Contenido vacio!!!").build();
		}
		
		String id = repository.newFiles(file, content, oauth);		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getAll");
		URI uri = ub.build();
		Response resp = Response.created(uri).entity(id).build();
		
		return resp;
	}

	@PUT
	@Path("/{id}")
	public Response updateFile(@PathParam("id") String id, @QueryParam("oauth") String oauth) {
		FileItem oldFile = repository.getFile(id, oauth);
		String oldContent = repository.getFileContent(oldFile , oauth);
		if (oldFile == null) {
			throw new NotFoundException("El fichero que se ha intentado modificar no se ha encontrado");
		} else {
			if (oldContent != null) {
				oldContent = "probando";
				repository.updateFile(oldFile.getId(), oldContent, oauth);
			}
		}

		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response removeFile(@PathParam("id") String id, @QueryParam("oauth") String oauth) {
		FileItem fileremoved = repository.getFile(id , oauth);
		if (fileremoved == null) {
			throw new NotFoundException("El archivo con el id deseado no fue encontrada");
		} else {
			repository.deleteFile(id , oauth);
		}
		return Response.noContent().build();
	}
}
