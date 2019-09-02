package galiber.CinemaProject.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "polls")
public class Poll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime start_date;
	
	@Column
	private LocalDateTime end_date;
	
	@Column
	private LocalDateTime due_date;
	
	
	@ManyToOne
	@JoinTable(
			name = "poll_user",
			joinColumns = @JoinColumn(name = "poll_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"))
	private User owner;
	
	@OneToMany
	private Set<PollEntry> entries;
	

	public Poll() {
		// TODO Auto-generated constructor stub
	}


	public Poll(Long id, LocalDateTime start_date, LocalDateTime end_date, LocalDateTime due_date, User owner,
			Set<PollEntry> entries) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.due_date = due_date;
		this.owner = owner;
		this.entries = entries;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getStart_date() {
		return start_date;
	}


	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}


	public LocalDateTime getEnd_date() {
		return end_date;
	}


	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}


	public LocalDateTime getDue_date() {
		return due_date;
	}


	public void setDue_date(LocalDateTime due_date) {
		this.due_date = due_date;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public Set<PollEntry> getEntries() {
		return entries;
	}


	public void setEntries(Set<PollEntry> entries) {
		this.entries = entries;
	}

}
