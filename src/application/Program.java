package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Room number:");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy):");
		Date dt1 = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy):");
		Date dt2 = sdf.parse(sc.next());

		if (!dt2.after(dt1)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation rs = new Reservation(number, dt1, dt2);

			System.out.println();
			System.out.println("Check-in date (dd/MM/yyyy):");
			dt1 = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy):");
			dt2 = sdf.parse(sc.next());

			Date now = new Date();
			if (dt1.before(now) || dt2.after(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} 
			else if (!dt2.after(dt1)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {
				rs.updateDate(dt1, dt2);
				System.out.println(rs);
			}
		}

		sc.close();
	}

}
