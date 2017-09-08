package aiss.model.resources;

import java.util.List;

import aiss.model.tmdbsearch.Result;

public class User{

	  /*
	  * La clase Usuario contiene una lista con las películas seleccionadas
	  * y otra lista con los videos seleccionados
	  *
	  *Las películas seleccionadas son de tipo Result
	  *Los videos se muestran a través de su id pero se postean a través
	  * de su url, que es: "https://www.youtube.com/embed/${x.id.videoId}"
	  * Es decir, un String, pero necesito el id de cada video
	  *
	  *
	  */

	private List<Result> TMDBResults;

	private List<String> YoutubeResults;

	public User(){
	}

	public User(List<Result> TMDBResults, List<String> YoutubeResults){
	  this.TMDBResults = TMDBResults;
	  this.YoutubeResults = YoutubeResults;
	}

	public List<Result> getTMBDResults(){
	  return TMDBResults;
	}

	public void setTMDBResults(List<Result> TMDBResults){
	  this.TMDBResults = TMDBResults;
	}

	public List<String> getYoutubeResults(){
	  return YoutubeResults;
	}
}
