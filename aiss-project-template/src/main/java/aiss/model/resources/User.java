package aiss.model.resources;

import java.util.List;

import aiss.model.tmdbsearch.Result;

public class User{

	  /*
	  * La clase Usuario contiene una lista con los videos seleccionados

	  *Los videos se muestran a través de su id pero se postean a través
	  * de su url, que es: "https://www.youtube.com/watch?v=${x.id.videoId},
	  *
	  *
	  */
	private List<String> YoutubeResults;

	public User(){
	}

	public User(List<String> YoutubeResults){
	  this.YoutubeResults = YoutubeResults;
	}


	public void setYoutubeResults(List<String> YoutubeResults){
	  this.YoutubeResults = YoutubeResults;
	}

	public List<String> getYoutubeResults(){
	  return YoutubeResults;
	}
}
