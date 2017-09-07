package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.GoogleDriveSingle;
import aiss.api.resources.TMDBResourceSingle;
import aiss.api.resources.YoutubeSingle;

public class SpotyGo extends Application{

	/**
	 * - API REST
   * -GET DE DRIVE
   * GET DE YOUTUBE
   * GET DE TMDB
   * UPDATE DE DRIVE
   * DELETE DE DRIVE
   * NEW DE DRIVE

	 */
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public SpotyGo(){
		singletons.add(TMDBResourceSingle.getInstance());
		singletons.add(YoutubeSingle.getInstance());
		singletons.add(GoogleDriveSingle.getInstance());
	}

	public Set<Object> getSingletons() {
		return singletons;
	}
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
}
