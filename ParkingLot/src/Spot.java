public class Spot extends ParkingLot {
	Vehicle compactSpot;
	Vehicle largeSpot;
	Vehicle motorcycleSpot;
	Spot Next;
	public Spot(Car car){
		while(ParkingLot.levels != 0){
			if(ParkingLot.compactSpots[levels-1] >= 1){
				compactSpot = car;
				ParkingLot.reduceCompact();
			}else if(ParkingLot.largeSpots[levels-1] >= 1){
				largeSpot = car;
				ParkingLot.reduceLarge();
			}else{
				ParkingLot.levels--;
			}
		}
		if(ParkingLot.levels == 0){
			System.out.println("Not enough spots left to park.");
		}
	}
	public Spot(Bus bus){
		if(ParkingLot.rows >= 1){
			while(ParkingLot.levels != 0){
				if(ParkingLot.largeSpots[ParkingLot.levels-1] >= 5){
					largeSpot = bus;
					ParkingLot.reduceLarge();
				}else{
					//System.out.println("Not enough spots left to park.");
					ParkingLot.levels--;
				}
			}
			if(ParkingLot.levels == 0){
				System.out.println("Not enough spots left to park.");
			}
		}
	}
	public Spot(Motorcycle motorcycle){
		while(ParkingLot.levels != 0){
			if(ParkingLot.motorcycleSpots[levels-1] >= 1){
				motorcycleSpot = motorcycle;
				ParkingLot.reduceMotorcycle();
			}else if(ParkingLot.compactSpots[levels-1] >= 1){
				compactSpot = motorcycle;
				ParkingLot.reduceCompact();
			}else if(ParkingLot.largeSpots[levels-1] >= 1){
				largeSpot = motorcycle;
				ParkingLot.reduceLarge();
			}else{
				ParkingLot.levels--;
			}
		}
		if(ParkingLot.levels == 0){
			System.out.println("Not enough spots left to park.");
		}
	}
	
}
