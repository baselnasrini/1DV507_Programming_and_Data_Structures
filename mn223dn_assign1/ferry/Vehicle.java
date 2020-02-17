package mn223dn_assign1.ferry;

public class Vehicle {

	protected int vehiPassenger = 0;

	public Vehicle() {

	}

	public int getVehiclePassCount() {
		return vehiPassenger;
	}

	public void addPassengerToVehicle(int n) {
		vehiPassenger += n;

	}

	public int getVehicleSpace() {
		if (this.getClass() == Bicycle.class) {
			return 1;
		} else if (this.getClass() == Car.class) {
			return 5;
		} else if (this.getClass() == Bus.class) {
			return 20;
		} else {
			return 40;
		}
	}

}
