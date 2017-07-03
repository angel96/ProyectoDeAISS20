
package aiss.model.youtube;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PageInfo implements Serializable{

    private Integer totalResults;
    private Integer resultsPerPage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PageInfo() {
    }

    /**
     * 
     * @param totalResults
     * @param resultsPerPage
     */
    public PageInfo(Integer totalResults, Integer resultsPerPage) {
        super();
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
