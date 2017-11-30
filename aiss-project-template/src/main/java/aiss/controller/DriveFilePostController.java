package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Item;
import aiss.model.youtube.Youtube;

public class DriveFilePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeSearchController.class.getName());

	public DriveFilePostController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> querySearch = new ArrayList<>();
		querySearch.addAll(Arrays.asList(request.getParameter("array").split("#")));
		querySearch.removeAll(Arrays.asList("",null));
		YoutubeResource yt = new YoutubeResource();
		List<Youtube> ls = new ArrayList<>();
		List<Item> ids = new ArrayList<Item>();
		
		for(String s: querySearch){
			ls.add(yt.getIdFromQuery(s));
	}

		for(Youtube t: ls){
			if (t != null) {
				Integer i;
				List<Item> a = new ArrayList<Item>();

				for (i = 0; i < t.getItems().size(); i++) {
					Item id = t.getItems().get(i);
					a.add(id);
				}
				ids.addAll(a);
				
			}
		}
		
		request.setAttribute("array", ids);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/EditFile.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
