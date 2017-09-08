package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.ResponseObject;

import aiss.model.repository.YoutubeRepository;
import aiss.model.youtube.Youtube;

@Path("/youtube")
public class YoutubeSingle {

	private static YoutubeSingle _instance = null;
	YoutubeRepository repository;
	
	private YoutubeSingle(){
		repository = YoutubeRepository.getInstance();
	}
	public static YoutubeSingle getInstance(){
		if(_instance == null){
			_instance = new YoutubeSingle();
		}
		return _instance;
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public Collection<Youtube> getAll(){
		return repository.init();
	}

}
