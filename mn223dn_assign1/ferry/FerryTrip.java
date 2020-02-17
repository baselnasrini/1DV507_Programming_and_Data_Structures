package mn223dn_assign1.ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryTrip implements Ferry {

	public int spaceCounter = 0;
	public int vehicleCounter = 0;
	public int passengerCounter = 0;
	public int money = 0;
	private final int MAX_SPACE = 200;
	private final int MAX_ROOM = 200;

	public ArrayList<Passenger> pass = new ArrayList<Passenger>();
	public ArrayList<Vehicle> vehi = new ArrayList<Vehicle>();

	public FerryTrip() {
	}

	public int countPassengers() {
		return passengerCounter;
	}

	public int countVehicleSpace() {
		return vehicleCounter;
	}

	public int countMoney() {
		return money;
	}

	public Iterator<Vehicle> iterator() {
		Iterator<Vehicle> it = vehi.iterator();
		return it;
	}

	public void embark(Vehicle v) {
		if (!hasSpaceFor(v)) {
			System.out.println("No more space on the ferry.");
		} else if (vehi.contains(v)) {
			System.out.println("The vehicle is already embarked.");
		} else if (v.getVehiclePassCount() > MAX_ROOM - passengerCounter) {
			System.out.println("No enough room .");
		}

		else {
			if (v.getClass() == Bicycle.class) {
				spaceCounter++;
				vehicleCounter++;
				addPassenger(v.getVehiclePassCount());
				vehi.add(v);
				money += 40;
				takeFee(v);
			} else if (v.getClass() == Car.class) {
				spaceCounter += 5;
				vehicleCounter++;
				addPassenger(v.getVehiclePassCount());
				vehi.add(v);
				money += 100;
				takeFee(v);
			} else if (v.getClass() == Bus.class) {
				spaceCounter += 20;
				vehicleCounter++;
				addPassenger(v.getVehiclePassCount());
				vehi.add(v);
				money += 200;
				takeFee(v);
			} else {
				spaceCounter += 40;
				vehicleCounter++;
				addPassenger(v.getVehiclePassCount());
				vehi.add(v);
				money += 300;
				takeFee(v);
			}

		}

	}

	public void embark(Passenger p) {
		if (!hasRoomFor(p)) {
			System.out.println("No room available.");
		} else {
			addPassenger(1);
			takePassFee(1);
		}
	}

	public void disembark() {
		pass.clear();
		vehi.clear();
		spaceCounter = 0;
		vehicleCounter = 0;
		passengerCounter = 0;
	}

	public boolean hasSpaceFor(Vehicle v) {
		return v.getVehicleSpace() <= MAX_SPACE - spaceCounter;
	}

	public boolean hasRoomFor(Passenger p) {
		return passengerCounter < MAX_ROOM;
	}

	public String toString() {
		return "The ferry has " + passengerCounter + " passengers and " + vehicleCounter + " vehicles.";
	}

	private void takeFee(Vehicle v) {
		int temp = v.getVehiclePassCount();
		if (v.getClass() == Bicycle.class) {
			for (int i = 0; i < 1; i++) {
				money += 15;
				temp--;
			}
			takePassFee(temp);
		} else if (v.getClass() == Car.class) {
			for (int i = 0; i < 4; i++) {
				money += 15;
				temp--;
			}
			takePassFee(temp);
		} else if (v.getClass() == Bus.class) {
			for (int i = 0; i < 20; i++) {
				money += 10;
				temp--;
			}
			takePassFee(temp);
		} else {
			for (int i = 0; i < 2; i++) {
				money += 15;
				temp--;
			}
			takePassFee(temp);
		}

	}

	private void takePassFee(int n) {
		for (int i = 0; i < n; i++)
			money += 20;
	}

	private void addPassenger(int n) {
		passengerCounter += n;
		for (int i = 0; i < n; i++)
			pass.add(new Passenger());
	}

}
