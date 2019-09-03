package galiber.CinemaProject.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int reservedSeats;
	
	@Column
	private int rowNo;
	
	@Column
	private LocalDateTime date;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}


	public Reservation(Long id, int reservedSeats, int rowNo, LocalDateTime date) {
		super();
		this.id = id;
		this.reservedSeats = reservedSeats;
		this.rowNo = rowNo;
		this.date = date;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	
	public int getRowNo() {
		return rowNo;
	}


	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}


	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
