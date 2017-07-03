package aiss.model.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.tmdbsearch.SearchTMDB;

public class TMDBResource {

	public String API_KEY = "81d8983da585c1cb7847fbd8a5d33e20";
	private static final Logger log = Logger.getLogger(TMDBResource.class.getName());

	public TMDBResource() {

	}

	public SearchTMDB getMoviesInfo(String query) {
		log.log(Level.FINE, "TOMANDO LA QUERY: " + query);
		SearchTMDB res = null;
		ClientResource cl = null;

		try {
			/**
			 * https://api.themoviedb.org/3/search/movie?api_key=81d8983da585c1cb7847fbd8a5d33e20
			 * &language=es-ES&query=transformers&page=1&include_adult=false
			 */
			cl = new ClientResource("https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY + "&language=es-ES&query="
					+ query + "&page=1&include_adult=false");
			res = cl.get(SearchTMDB.class);
		} catch (ResourceException e) {
			System.err.print(e.getStackTrace());
		}
		return res;
	}
}
