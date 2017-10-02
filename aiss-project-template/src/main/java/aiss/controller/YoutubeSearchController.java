package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String[] querySearch = request.getParameter("array").split("#");
		HttpSession session = request.getSession();
		session.setAttribute("querySearch", querySearch);
		RequestDispatcher rd = null; // manda a la vista
		YoutubeResource yt = new YoutubeResource(); // conseguir objeto youtube
		List<Youtube> ls = new ArrayList<Youtube>();
		List<String> ids = new ArrayList<String>();

		for(String s: querySearch){
			if (s != null || s != "" || s != " " || s != ".") {
				ls.add(yt.getIdFromQuery(s));
			}
		}
		
		for(Youtube t: ls){
			if (t != null) {
				Integer i;
				List<String> a = new ArrayList<String>();
				for (i = 0; i < t.getItems().size(); i++) {
					String id = t.getItems().get(i).getId().getVideoId();
					a.add(id);
				}
				//String id = t.getItems().get(0).getId().getVideoId();
				ids.addAll(a);
			}
		}
		rd = request.getRequestDispatcher("/YoutubeResults.jsp");
		request.setAttribute("videos", ids);
		
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