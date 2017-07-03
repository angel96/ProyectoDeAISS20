
package aiss.model.tmdbsearch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable
{

    private Integer voteCount;
    private Integer id;
    private Boolean video;
    private Integer voteAverage;
    private String title;
    private Double popularity;
    private String posterPath;
    private String originalLanguage;
    private String originalTitle;
    private List<Integer> genreIds = null;
    private Object backdropPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;
   

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param genreIds
     * @param id
     * @param title
     * @param releaseDate
     * @param overview
     * @param posterPath
     * @param originalTitle
     * @param voteAverage
     * @param originalLanguage
     * @param adult
     * @param backdropPath
     * @param voteCount
     * @param video
     * @param popularity
     */
    public Result(Integer voteCount, Integer id, Boolean video, Integer voteAverage, String title, Double popularity, String posterPath, String originalLanguage, String originalTitle, List<Integer> genreIds, Object backdropPath, Boolean adult, String overview, String releaseDate) {
        super();
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Object getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
