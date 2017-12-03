package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Developers extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(Developers.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 
		resp.setContentType("text/html");
		resp.getWriter().println("<html>"
				+ "<head><style>\n" + 
				".card {\n" + 
				"    box-shadow: 0 4px 6px 0 rgba(0,0,0,0.2);\n" + 
				"    transition: 0.3s;\n" + 
				"    width: 15%;\n"
				+ 
				"}\n" + 
				"\n" + 
				".card:hover {\n" + 
				"    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);\n" + 
				"}\n" + 
				"\n" + 
				".container {\n" + 
				"    padding: 2px 16px;\n" 
				+ "}\n" + 
				"</style>\n" + 
				"<title>Desarrolladores</title></head>"
				+ "<body>"
				+ "<h1>Desarrolladores</h1> "
				+ "<div class=\"card\">\n" + 
				"  <img src=\"images/photo_2017-04-25_01-05-25.jpg\" style=\"width:100%\">\n" + 
				"  <div id = 'card1' class=\"container\">\n" + 
				"    <h4><b>Ángel Delgado Luna</b></h4> \n" + 
				"    <p>Estudiante de Ingeniería del Software - 3º Curso</p> \n" + 
				"  </div></div>\n"
				+ "<div class=\"card\">\n"
				+ "<img src=\"images/images.jpg\" style=\"width:100%\">\n" 
				+"  <div id = 'card2' class=\"container\">\n" + 
				"    <h4><b>Reyes Cabello Holgado</b></h4> \n" + 
				"    <p>Estudiante de Ingeniería del Software - 2º Curso</p> \n" + 
				"  </div>\n" +  
				"</div>"  
						
						+ "</br><a href = '/index.jsp'>Volver al inicio</a></p></body>"
				+ "</html>");
	}
}