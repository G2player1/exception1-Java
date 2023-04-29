package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long dif = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String updateDate(Date checkin,Date checkout) {
		Date now = new Date();
		if (!checkin.before(now) || !checkout.after(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		} 
		else if (!checkout.after(checkin)) {
			return "Error in reservation: Check-out date must be after check-in date";
		} 
		else {
			this.checkin = checkin;
			this.checkout = checkout;
			System.out.println(this.toString());
			return "Date updated";
		}
		
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", check-in: " 
				+ sdf.format(checkin) 
				+ ", check-out: " 
				+ sdf.format(checkout) 
				+ ", " + duration() 
				+ " nights";
	}
	
	

}
