package aiss.model.repository;

import java.util.ArrayList;
import java.util.List;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Youtube;

public class YoutubeRepository {

	// GET YOUTUBE
	private Youtube search;
	private static YoutubeRepository instance = null;

	public static YoutubeRepository getInstance() {

		if (instance == null) {
			instance = new YoutubeRepository();
			instance.init();
		}
		return instance;
	}

	public List<Youtube> init(){
			
			List<String> busquedas = new ArrayList<String>();
			
			busquedas.add("Transformers");
			busquedas.add("Juego de Tronos");
			busquedas.add("3 metros sobre el cielo");

			List<Youtube> ls = new ArrayList<Youtube>();
			
			YoutubeResource tm = new YoutubeResource();
			
			Youtube s1 = tm.getIdFromQuery(busquedas.get(0));
			Youtube s2 = tm.getIdFromQuery(busquedas.get(1));
			Youtube s3 = tm.getIdFromQuery(busquedas.get(2));
			
			ls.add(s1);
			ls.add(s2);
			ls.add(s3);
			
			return ls;
			
		}
}
