package mn223dn_assign1.ferry;

import java.util.Iterator;

public class FerryMain {

	public static void main(String[] args) {
		Ferry t = new FerryTrip();

		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();
		t.embark(p1);
		t.embark(p2);

		Vehicle b1 = new Bicycle();
		Vehicle b2 = new Bicycle();
		t.embark(b1);
		t.embark(b2);

		Vehicle c1 = new Car();
		Vehicle c2 = new Car();
		c2.addPassengerToVehicle(2);
		t.embark(c1);
		t.embark(c2);

		Vehicle l1 = new Lorry();
		l1.addPassengerToVehicle(1);

		t.embark(l1);
		t.embark(l1);

		System.out.println("Passenger : " + t.countPassengers());
		System.out.println("Vehicle : " + t.countVehicleSpace());
		System.out.println("Money: " + t.countMoney());
		System.out.println(t);

		Iterator<Vehicle> it = t.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");

		System.out.println();

		t.disembark();
		System.out.println(t);
		System.out.println("Money after disembark: " + t.countMoney());

	}

}
