package aiss.model.resources;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.Youtube;

public class YoutubeResource {
	public String API_KEY = "AIzaSyA8D5TT3FHvNuwsjn1hyYBolekLcpjCr8k";

	public YoutubeResource() {

	}

	public Youtube getIdFromQuery(String query) {
		// https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&q="
		// + keyword + "&key=YOUR_YOUTUBE_API_KEY
		// TODO: REALIZAR METODO
		String URI = 
				"https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=2&order=rating&q="+query
				+ "&key=" + API_KEY;
		
		Youtube res = null;
		ClientResource cl = null;
		
		try{
			cl = new ClientResource(URI);
			res = cl.get(Youtube.class);
		} catch (ResourceException e){
			System.err.print(e.getStackTrace());
		}
		
		return res;
	}
}
