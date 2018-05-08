public class ParkingLot {

	private Car[] lot;
	
	ParkingLot(){
		lot = new Car[10];
	}
	
	ParkingLot(int size) {
		lot = new Car[size];
	}
	
	public void enterLot(Car c) {
		boolean foundSpot = false;
		int i =0;
		while(!foundSpot && i<lot.length) {
			if(lot[i] ==null) {
				lot[i]=c;
				foundSpot =true;
			}
			i++;
		}
		
	}
	public Car exitLot(String id) {
		boolean found = false;
		Car myCar = null;
		int i =0;
		while(!found && i<lot.length) {
			if(lot[i] != null && lot[i].getVehicleID().equals(id)) {
				myCar =lot[i];
				found = true;
				lot[i] =null;
				System.out.println("found in spot: "+i);
			}
			i++;
		}
		return myCar;
	}
}
