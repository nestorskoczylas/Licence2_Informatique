public class BikeStation {

    /** array of slots for bikes in the station */
    private Bike[] bikes;
    /** name of the station */
    private String name;
	private int capacity;
	private int nbOfBikes;

    /**
     * create a Bike Station with given name and sets the capacity
	 * @param name : bike station's name
	 * @param capacity : number of bike's slot of the station
     */
	public BikeStation(String name, int capacity) {
	    this.name = name;
		this.capacity = capacity;
		this.bikes = new Bike[capacity];
	}

    /**
     * method of obtaining the station name
	 * @return the name of the station
     */
	public String getName() {
	    return this.name;
	}

    /**
     * method of obtaining the capacity of the bike station
	 * @return the capacity of the bike station
     */
	public int getCapacity() {
		return thus.capacity;
	}

    /**
     * method of obtaining the number of bikes
	 * @return the number of bikes
     */
	public int getNumberOfBikes() {
	    int cpt = 0;
		for(int i = 0; i < this.capacity; i++) {
			if (this.bikes[i] != null) {
				cpt++;
			}
		}
		return cpt;
	}

    
    /*
     * method of obtaining the first free slots
	 * @return a the smaller slot of free bike station
     */
	public int firstFreeSlot() {
		for (int i = 0; i < this.capacity; i++) {
			if (this.bikes[i] == null) {
				return i;
			}
		}
		return -1;
	}
	

    /**
     * method allows you to drop off a bike at a station
	 * @param bike to drop in the station
	 * @return if there is free slot
     */
	public boolean dropBike(Bike bike) {
	    if (this.firstFreeSlot() != -1){
			this.nbOfBikes++;
			this.bikes[firstFreeSlot()] = bike;
			return true;
		}
		return false;
	}
	
	
	
    /**
     * method takes the bike at index i in the station, if there is one
	 @param i : index where we take the bike
	 @return object bike taken at index i when we are inside and null if there was no bike
     */
	public Bike takeBike(int i) {
	    if(i < this.capacity && i >= 0 && this.bikes[i] != null) {
			Bike tmp;
			tmp = this.bikes[i];
			this.bikes[i] = null;
			return tmp;
		}
		else {
			return null;
		}
	
	}

	/**
	* Creation of a BikeStation named Timoleon with 10 slots and 2 bikes in the first two slots
	* Method takes a bike in the slot passed in parameter. If there is a bike return the bike object, otherwise say that there is no
	@param args: the index where we try to take the bikes, whose first bike is at index 0
	*/
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Write the number of the place where you want to take a bike");
		}
		else {
			BikeStation station = new BikeStation("Timoleon",10);
		
			station.dropBike(new Bike("b001",BikeModel.CLASSICAL));
			station.dropBike(new Bike("b002",BikeModel.ELECTRIC));
		
			Bike emplacement=station.takeBike(Integer.parseInt(args[0]));
			if (emplacement == null) {
				System.out.println("No bikes in this location");
			}
			else{
				System.out.println(emplacement.toString());
			}

		}

	}
	
}
