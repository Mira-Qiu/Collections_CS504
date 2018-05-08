

public class Car {

	private String vehicle_id;
	private int speed;
	
	Car(){
		this.vehicle_id="";
		this.speed=0;
	}
	
	Car(String vehicle_id){
		this.vehicle_id=vehicle_id;
	}
	
	Car(String id, int spd){
		this.vehicle_id=id;
		this.speed=spd;
	}
	
	public void setVehicleID(String id) {
		this.vehicle_id=id;
	}
	
	public void setSpeed(int spd) {
		this.speed=spd;
	}
	
	public String getVehicleID() {
		return vehicle_id;
	}
	
	public int getSpeed() {
		return speed;
	}
}
