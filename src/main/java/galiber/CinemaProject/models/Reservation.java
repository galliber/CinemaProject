package galiber.CinemaProject.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int reservedSeats;
	private int row;
	private LocalDateTime date;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

}
