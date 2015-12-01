
public class Vehicle {
	private String vehicleName;
	public Vehicle(String name){
		setVehicleName(name);
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	Vehicle next;
}
