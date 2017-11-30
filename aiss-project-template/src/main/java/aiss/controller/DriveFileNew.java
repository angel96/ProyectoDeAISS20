package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.FileItem;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileNew extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileNew.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("GoogleDrive-token");
		String title = req.getParameter("title");
		log.log(Level.ALL, "Obteniendo array de seleccionados de youtube" + req.getParameter("selected"));
		String content = (String)req.getAttribute("content");
		if(accessToken!=null && !"".equals(accessToken)){
			if(title!=null && !"".equals(title)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				FileItem file = new FileItem();
				file.setTitle(title+".txt");
				file.setMimeType("text/plain");
				gdResource.insertFile(file, content);
				req.setAttribute("message", "El archivo '"+title+"' ha sido añadido a Google Drive.");
				req.getRequestDispatcher("/googleDriveListing").forward(req,resp);

			}
		}else{
			log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
