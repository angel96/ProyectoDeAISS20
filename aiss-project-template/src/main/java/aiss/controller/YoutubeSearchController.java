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
		/*a.split("%a%")*/
		String a = request.getParameter("array");
		String[] querySearch= {"Harry potter y la orden del fenix"};
		RequestDispatcher rd = null; //manda a la vista
		YoutubeResource yt = new YoutubeResource(); //conseguir objeto youtube
		Youtube[] searchyt = null;
		int i;
		for(i=0; i<querySearch.length;i++) {
			if (querySearch[i] != null || querySearch[i] != "" || querySearch[i] != " " || querySearch[i] != ".") {
				searchyt[i] = yt.getIdFromQuery(querySearch[i]);
			}
			if (searchyt[i] != null) {
				rd = request.getRequestDispatcher("/YoutubeResults.jsp");
				request.setAttribute("videos", searchyt[i].getItems());
			} else {
				continue;
				/*
				log.log(Level.SEVERE, "Youtube object: " + searchyt);
				rd = request.getRequestDispatcher("/error.jsp");
				*/
			}
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