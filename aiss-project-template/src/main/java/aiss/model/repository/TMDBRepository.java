package aiss.model.repository;

import java.util.ArrayList;
import java.util.List;

import aiss.model.resources.TMDBResource;
import aiss.model.tmdbsearch.SearchTMDB;

public class TMDBRepository {

	// GET TMDB
	private static TMDBRepository instance = null;

	public static TMDBRepository getInstance() {

		if (instance == null) {
			instance = new TMDBRepository();
			instance.init();
		}
		return instance;
	}

	public List<SearchTMDB> init() {

		List<String> busquedas = new ArrayList<String>();
		busquedas.add("Transformers");
		busquedas.add("Star Wars");
		busquedas.add("3 metros sobre el cielo");

		List<SearchTMDB> ls = new ArrayList<SearchTMDB>();

		TMDBResource tm = new TMDBResource();

		SearchTMDB s1 = tm.getMoviesInfo(busquedas.get(0));
		SearchTMDB s2 = tm.getMoviesInfo(busquedas.get(1));
		SearchTMDB s3 = tm.getMoviesInfo(busquedas.get(2));

		ls.add(s1);
		ls.add(s2);
		ls.add(s3);

		return ls;

	}
}
