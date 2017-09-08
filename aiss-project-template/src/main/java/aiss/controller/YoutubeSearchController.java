package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Youtube;

/**
 * Servlet implementation class YoutubeSearchController
 */
public class YoutubeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YoutubeSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String querySearch = request.getParameter("query");
		RequestDispatcher rd = null;
		YoutubeResource yt = new YoutubeResource();
		Youtube searchyt = null;
		if (querySearch != null || querySearch != "" || querySearch != " " || querySearch != ".") {
			searchyt = yt.getIdFromQuery(querySearch);
		}
		if (searchyt != null) {
			rd = request.getRequestDispatcher("/YoutubeResults.jsp");
			request.setAttribute("videos", searchyt.getItems());
		} else {
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