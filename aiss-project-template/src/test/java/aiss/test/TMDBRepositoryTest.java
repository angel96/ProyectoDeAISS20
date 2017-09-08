package aiss.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import aiss.model.repository.TMDBRepository;
import aiss.model.tmdbsearch.SearchTMDB;

public class TMDBRepositoryTest {

	private TMDBRepository rep;
	private List<SearchTMDB> ls;
	private int i;

	@Before
	public void setUp() throws Exception {
		rep = TMDBRepository.getInstance();
		/**
		 * rep.init() --> Devuelve una lista de objetos ya consultados
		 */
		ls = rep.init();
	}

	@Test
	public void getSearchNotNull() throws UnsupportedEncodingException {

		for (i = 0; i < ls.size(); i++) {
			assertNotNull("Comprobando que la lista del repositorio no sea nula", ls.get(i).getResults());

		}

	}

	@Test
	public void getSearchResultsMayorThan() throws UnsupportedEncodingException {
		assertTrue("Comprobar que se obtienen los objetos", ls.get(i).getResults().size() > 1);
	}
}
