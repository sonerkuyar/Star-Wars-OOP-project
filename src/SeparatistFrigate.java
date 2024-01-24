import java.util.ArrayList;

public class SeparatistFrigate  extends SeparatistDestroyer implements IWarship{
	/*
	* Necessary methods
	*/
	public SeparatistFrigate(int id, String name, Sector currentSector, int coordinate, ArrayList<Crewman> crew) {
		super(id, name, currentSector, coordinate, crew);
		armamentPower = 120;
		shieldPower = 100;
		crewCapacity  = 12;
		escapePods = 2;
		
	}
	

}
