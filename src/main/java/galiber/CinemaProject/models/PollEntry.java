package galiber.CinemaProject.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "poll_entries")
public class PollEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int votes;
	
	@ManyToOne
	private Movie movie;
	
	
	@ManyToMany
	@JoinTable(name = "poll_entries_voters",
			joinColumns = @JoinColumn(name = "pe_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "voer_id", referencedColumnName = "id"))
	private Set<User> voters;
	
	
	public PollEntry() {
		// TODO Auto-generated constructor stub
	}


	public PollEntry(Long id, int votes, Movie movie, Set<User> voters) {
		super();
		this.id = id;
		this.votes = votes;
		this.movie = movie;
		this.voters = voters;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Set<User> getVoters() {
		return voters;
	}


	public void setVoters(Set<User> voters) {
		this.voters = voters;
	}

}
