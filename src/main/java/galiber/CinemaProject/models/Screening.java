package galiber.CinemaProject.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "screenings")
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime start;
	
	@Column
	private LocalDateTime end;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private Hall hall;
	public Screening() {
		// TODO Auto-generated constructor stub
	}
	public Screening(Long id, LocalDateTime start, LocalDateTime end, Movie movie, Hall hall) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.movie = movie;
		this.hall = hall;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
