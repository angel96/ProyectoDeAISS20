
package aiss.model.tmdbsearch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTMDB implements Serializable {

	private Integer page;
	private Integer totalResults;
	private Integer totalPages;
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
	 * @param totalResults
	 * @param page
	 * @param totalPages
	 */
	public SearchTMDB(Integer page, Integer totalResults, Integer totalPages, List<Result> results) {
		super();
		this.page = page;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
