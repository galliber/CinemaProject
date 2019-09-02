package galiber.CinemaProject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	private String authority;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, @NotNull String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
