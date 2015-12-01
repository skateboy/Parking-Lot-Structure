public class ParkingLot {
	protected static int levels = 5;	// Creates total levels available to park vehicles on
	protected static int rows = 3;		// Specifies number of rows on each level
	private static int spots[][] = {{10, 10, 10},{10, 10, 10},{10, 10, 10},{10,10,10},{10,10,10}};	// Specifies total spots available on each row.
	public static int largeSpots[] = {6, 6, 6, 6, 6};	// Specifies number of large spots available on each level
	public static int motorcycleSpots[] = {6, 6, 6, 6, 6}; // Specifies number of motorcycle spots available on each level
	public static int compactSpots[] = {18, 18, 18, 18, 18}; // Specifies number of compact spots on each level
	public static void reduceCompact(){
		compactSpots[levels-1]--;
		while(spots[levels-1][rows-1]==0){
			rows--;
			if(rows==0){
				levels--;
			}
			if(levels == 0){
				System.out.println("There are no available spots left to park in.");
			}
		}
		while(spots[levels-1][rows-1] != 0){
			if(spots[levels-1][rows-1] >= 4){
				spots[levels-1][rows-1]--;
				break;
			} else {
				rows--;	
				if(rows==1){
					spots[levels-1][rows-1]--;
					break;
				}
			}
		}
		rows = 3;
		levels = 5;
	}
	public static void reduceLarge(){
		while(largeSpots[levels-1] == 0){
			levels--;
		}
		largeSpots[levels-1]--;
		if(largeSpots[levels-1]+1 != 0){
			if(spots[levels-1][rows-1] == 0){
				levels--;
				spots[levels-1][rows-1]--;
				levels++;
				if(rows == 0){
					levels--;
				}
			} else {
				spots[levels-1][rows-1]--;
			}
		}
		rows = 3;
		levels = 5;
	}
	public static void reduceMotorcycle(){
		while(motorcycleSpots[levels-1] == 0){
			levels--;
		}
		motorcycleSpots[levels-1]--;
		if(motorcycleSpots[levels-1]+1 != 0){
			int count = 0;
			if(spots[levels-1][rows-2] == 0){
				levels--;
				while(spots[levels-1][rows-2] == 0){
					levels--;
					count++;
				}
				if(levels==0){
					System.out.println("Sorry, there are no more motorcycle spots left.");
				}else{
					spots[levels-1][rows-2]--;
					levels+=count;
				}
			} else {
				spots[levels-1][rows-2]--;
			}
		}
		rows = 3;
		levels=5;
	}
}
