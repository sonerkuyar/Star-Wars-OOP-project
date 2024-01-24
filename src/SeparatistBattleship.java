import java.util.ArrayList;

public class SeparatistBattleship  extends SeparatistDestroyer{
	/*
	* Necessary methods
	*/
	public SeparatistBattleship(int id, String name, Sector currentSector, int coordinate, ArrayList<Crewman> crew) {
		super(id, name, currentSector, coordinate, crew);
		armamentPower = 400;
		shieldPower = 200;
		crewCapacity = 20;
		escapePods = 3;
		
	}

}
