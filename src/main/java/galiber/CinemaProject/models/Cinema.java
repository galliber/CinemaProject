package galiber.CinemaProject.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cinemas")
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private LocalDateTime created;
	
	@Column
	private LocalDateTime modified;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User owner;
	
	@ManyToMany
	@JoinTable(
			name = "cinma_movie",
			joinColumns = @JoinColumn(name = "cinema_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
	private Set<Movie> screenedMovies;
	
	@OneToMany
	private Set<Hall> halls;
	

	public Cinema() {
		// TODO Auto-generated constructor stub
	}


	public Cinema(Long id, String name, String address, LocalDateTime created, LocalDateTime modified, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.created = created;
		this.modified = modified;
		this.owner = owner;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public LocalDateTime getModified() {
		return modified;
	}


	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}

}
