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

}
