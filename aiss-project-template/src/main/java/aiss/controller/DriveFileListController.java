package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileListController extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileListController.class.getName());
	public static String accessToken;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		accessToken = (String)req.getSession().getAttribute("GoogleDrive-token");
		if(accessToken!=null && !"".equals(accessToken)){
			GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
			Files files = gdResource.getFiles();
			if (files != null) {
				String view = req.getParameter("view");
				if (view == null) {
					view = "1";
				}
				Integer v = Integer.parseInt(view);
				List<FileItem> filter = new ArrayList<>();
				for (FileItem file : files.getItems()) {
					String a = file.getOriginalFilename();
					if (a == null) {
						a = "0";
					}
					String b = "SpotyGoFile";
					if (a.compareTo(b) == 0) {
						filter.add(file);
					}
				}
				if (v == 0) {
					req.setAttribute("files", files.getItems());
				} else {
					req.setAttribute("files", filter);
				}

				req.getRequestDispatcher("/GoogleDriveFileListing.jsp").forward(req, resp);
			}else{
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);

			}
		}else{
			log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}

