package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

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
	public Collection<FileItem> getAll(){
		return repository.init().getItems();
	}
	@POST
	@Path("/drivepost")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addFile (@Context UriInfo uriInfo, FileItem file, String content){
		if(file == null){
			throw new BadRequestException("El fichero es nulo");
		}
		if(content == null || content == ""){
			throw new BadRequestException("El contenido no puede ser nulo ni vacio");
		}
		repository.newFiles(file, content);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(file.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(file);			
		return resp.build();
	}

	
}
