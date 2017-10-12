package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TMDBResource;
import aiss.model.tmdbsearch.SearchTMDB;

/**
 * Servlet implementation class TMDBSearchController
 */
public class TMDBSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TMDBSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TMDBSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String querySearch = request.getParameter("query");
		ArrayList<String> before = new ArrayList<>();
		ArrayList<String> ids = new ArrayList<>();
		if(!request.getParameter("selected").equals(null)) {
			before.addAll(Arrays.asList(request.getParameter("selected").split("#")));
			before.removeAll(Arrays.asList(null,""));
		}
		if(!request.getParameter("ids").equals(null)) {
			ids.addAll(Arrays.asList(request.getParameter("ids").split("#")));
			ids.removeAll(Arrays.asList(null,""));
			
		}
		

		RequestDispatcher rd = null;
		log.log(Level.FINE, "Searching for TMDB albums of " + querySearch);
		TMDBResource tmdb = new TMDBResource();
		SearchTMDB searchtmdb = null;
		if (querySearch != null || querySearch != "" || querySearch != " " || querySearch != ".") {
			searchtmdb = tmdb.getMoviesInfo(querySearch);
		}
		if (searchtmdb != null) {
			rd = request.getRequestDispatcher("/TMDBResults.jsp");
			request.setAttribute("results", searchtmdb.getResults());
			if(!before.isEmpty()) {
			request.setAttribute("before",before);
			}
			if(!ids.isEmpty()) {
				request.setAttribute("ids",ids);
			}
			
		} else {
			log.log(Level.SEVERE, "TMDB object: " + searchtmdb);
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
