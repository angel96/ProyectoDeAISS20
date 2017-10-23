
package aiss.model.tmdbsearch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTMDB implements Serializable {

	private Integer page;
	private Integer total_results;
	private Integer total_pages;
	private List<Result> results = null;
	
	private final static long serialVersionUID = 5151778559075278228L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SearchTMDB() {
	}

	/**
	 * 
	 * @param results
	 * @param total_results
	 * @param page
	 * @param total_pages
	 */
	public SearchTMDB(Integer page, Integer total_results, Integer total_pages, List<Result> results) {
		super();
		this.page = page;
		this.total_results = total_results;
		this.total_pages = total_pages;
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal_results() {
		return total_results;
	}

	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
