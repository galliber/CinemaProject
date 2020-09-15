package galiber.CinemaProject.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	@Size(min = 3, max = 20, message = "First Name should be at least 3 symbols long.")
	private String firstName;

	@Column
	@NotNull
	@Size(min = 3, max = 20, message = "Last Name should be at least 3 symbols long.")
	private String lastName;

	@Column
	@NotNull
	@Size(min = 3, max = 30, message = "Username should be at least 3 symbols long.")
	private String username;

	@Column
	@NotNull
	private String password;

	@Column
	@NotNull
	@Email
	private String email;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "watched_movies")
	private Set<Movie> watchedMovies;

	@ManyToMany
	@JoinTable(
			name = "user_favourite",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
	private Set<Movie> favourites;

	@OneToMany
	private Set<Reservation> reservations;

	@Column
	private LocalDateTime created;

	@Column
	private LocalDateTime modified;

	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;

	public User() {
		this.watchedMovies=new HashSet<Movie>();
		this.favourites=new HashSet<Movie>();
		this.reservations=new HashSet<Reservation>();
		this.roles=new HashSet<Role>();
		this.created=LocalDateTime.now();
		this.modified=LocalDateTime.now();
	}

	public User(Long id,
			@NotNull @Size(min = 3, max = 20, message = "First Name should be at least 3 symbols long.") String firstName,
			@NotNull @Size(min = 3, max = 20, message = "Last Name should be at least 3 symbols long.") String lastName,
			@NotNull @Size(min = 3, max = 30, message = "Username should be at least 3 symbols long.") String username,
			@NotNull String password, @NotNull @Email String email, Status status, Set<Movie> watchedMovies,
			Set<Movie> favourites, Set<Reservation> reservations, LocalDateTime created, LocalDateTime modified,
			Set<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.watchedMovies = watchedMovies;
		this.favourites = favourites;
		this.reservations = reservations;
		this.created = created;
		this.modified = modified;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Movie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(Set<Movie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	public Set<Movie> getFavourites() {
		return favourites;
	}

	public void setFavourites(Set<Movie> favourites) {
		this.favourites = favourites;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.status.equals(Status.ACTIVE);
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.status.equals(Status.ACTIVE);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.status.equals(Status.ACTIVE);
	}

	@Override
	public boolean isEnabled() {
		return this.status.equals(Status.ACTIVE);
	}

}
