import java.util.ArrayList;

public abstract class Warship implements IWarship {
	/*
	* Necessary fields
	*/
	int id;
	String name;
	Sector currentSector;
	int coordinate;
	int armamentPower;
	int shieldPower;
	int crewCapacity;
	ArrayList<Crewman> crew;
	/*
	* Necessary methods
	*/
	protected Warship() {
		
	}
	protected Warship(int id,String name, Sector currentSector, int coordinate,
	ArrayList<Crewman> crew) {
		
		this.id = id;
		this.name =name;
		this.currentSector = currentSector;
		this.coordinate = coordinate;
		this.crew = crew;//not sure
		
//		TODO
	}

}
