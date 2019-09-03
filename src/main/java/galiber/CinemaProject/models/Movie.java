package galiber.CinemaProject.models;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String enTitle;
	
	@Column
	private String bgTitle;
	
	@Column
	private String imdbID;
	
	@Column
	private String tmdbID;
	
	@Column
	private String language;
	
	@Column
	private String posterURL;
	
	@Column
	private String genres;
	
	@Column
	private int runtime;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(Long id, String enTitle, String bgTitle, String imdbID, String tmdbID, String language,
			String posterURL, String genres, int runtime) {
		super();
		this.id = id;
		this.enTitle = enTitle;
		this.bgTitle = bgTitle;
		this.imdbID = imdbID;
		this.tmdbID = tmdbID;
		this.language = language;
		this.posterURL = posterURL;
		this.genres = genres;
		this.runtime = runtime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnTitle() {
		return enTitle;
	}
	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}
	public String getBgTitle() {
		return bgTitle;
	}
	public void setBgTitle(String bgTitle) {
		this.bgTitle = bgTitle;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getTmdbID() {
		return tmdbID;
	}
	public void setTmdbID(String tmdbID) {
		this.tmdbID = tmdbID;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPosterURL() {
		return posterURL;
	}
	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	

}
