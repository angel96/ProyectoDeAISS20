package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TMDBResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.tmdbsearch.SearchTMDB;
import aiss.model.youtube.Youtube;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String querySearch = request.getParameter("query");

		RequestDispatcher rd = null;
		log.log(Level.FINE, "Searching for TMDB albums of " + querySearch);
		TMDBResource tmdb = new TMDBResource();
		YoutubeResource yt = new YoutubeResource();
		SearchTMDB searchtmdb = tmdb.getMoviesInfo(querySearch);
		Youtube searchyt = yt.getIdFromQuery(querySearch);


		if (searchtmdb != null && searchyt != null) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("results", searchtmdb.getResults());
			request.setAttribute("videos", searchyt.getItems());
		} else {
			log.log(Level.SEVERE, "TMDB object: " + searchtmdb);
			log.log(Level.SEVERE, "Youtube object: " + searchyt);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
