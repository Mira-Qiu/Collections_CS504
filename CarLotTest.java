public class CarLot {

	public static void main(String[] args) {
		
		Car bob = new Car();
		bob.setSpeed(60);
		bob.setVehicleID("bob123");
		
		System.out.println("Bob id = "+bob.getVehicleID()+" bob speed = "+bob.getSpeed());
		
		String veh_id ="bob123";
		Car[] lot = new Car[3];
		lot[0] = bob;
		lot[1] = new Car("Sue123",70);
		lot[2] = new Car("pro345",90);
		
		boolean found = false;
		for(int i =0; i<lot.length;i++)
			if(lot[i].getVehicleID().equals(veh_id))
				found =true;
		if(found)
			System.out.println("found");
		else
			System.out.println("not found");
		
	}
}
