package aiss.api;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.GoogleDriveSingle;
import aiss.api.resources.TMDBResourceSingle;
import aiss.api.resources.YoutubeSingle;

public class Spotygo extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public Spotygo(){
		singletons.add(TMDBResourceSingle.getInstance());
		singletons.add(YoutubeSingle.getInstance());
		singletons.add(GoogleDriveSingle.getInstance());
	}

	
	public Set<Class<?>> getClasses() {
		return classes;
	}
	public Set<Object> getSingletons() {
		return singletons;
	}
}
