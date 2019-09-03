package galiber.CinemaProject.models;

import javax.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int number;
	
	@Column
	private int seatsCount;
	
	@Column
	private int rowCount;
	
	
	public Hall() {
		// TODO Auto-generated constructor stub
	}


	public Hall(Long id, int number, int seatsCount, int rowCount) {
		super();
		this.id = id;
		this.number = number;
		this.seatsCount = seatsCount;
		this.rowCount = rowCount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getSeatsCount() {
		return seatsCount;
	}


	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}


	public int getRowCount() {
		return rowCount;
	}


	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

}
