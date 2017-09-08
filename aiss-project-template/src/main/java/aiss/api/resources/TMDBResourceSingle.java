package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import aiss.model.repository.TMDBRepository;
import aiss.model.tmdbsearch.SearchTMDB;

@Path("/tmdb")
public class TMDBResourceSingle {
	/*Singleton/
	 * 
	 */
	private static TMDBResourceSingle _instance = null;
	TMDBRepository repository;
	
	private TMDBResourceSingle(){
		repository = TMDBRepository.getInstance();
	}
	public static TMDBResourceSingle getInstance(){
		if(_instance == null){
			_instance = new TMDBResourceSingle();
		}
		return _instance;
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public Collection<SearchTMDB> getAll(){
		return repository.init();
	}
	

}
