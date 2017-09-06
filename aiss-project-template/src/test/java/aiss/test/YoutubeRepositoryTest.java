package aiss.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import aiss.model.repository.YoutubeRepository;
import aiss.model.youtube.Youtube;

public class YoutubeRepositoryTest {

	private YoutubeRepository rep;

	private List<Youtube> ls;
	private int i;

	@Before
	public void setUp() throws Exception {
		rep = YoutubeRepository.getInstance();
		/**
		 * rep.init() --> Devuelve una lista de objetos ya consultados
		 */
		ls = rep.init();
	}

	@Test
	public void testGetIdFromQuery() throws UnsupportedEncodingException {
		for (i = 0; i < ls.size(); i++) {
			assertNotNull("Comprobando que lo obtenido no sea nulo: ", ls.get(i));
		}
	}

}
