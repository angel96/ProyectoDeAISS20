package aiss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;

public class SessionController extends HttpServlet{

	  private static final long serialVersionUID = 1L;
	  private List<String> Youtube;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException{
	    HttpSession newSession = request.getSession(true);
	    //User newUser = new User(Youtube);
	    //newSession.setAttribute("user", newUser);

	  /**crear ambas listas**/
	}
}
