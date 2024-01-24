
public abstract class Crewman {
	/*
	* Necessary fields
	*/
	protected int id;
	protected String name;
	protected boolean isFree = true;
	protected boolean imprisoned;
	/*
	* Necessary methods
	*/
	protected Crewman() {
		
	}
	protected Crewman(int id, String name)
	{
		this.id = id;
		this.name = name;
		
	}
	protected int getExperience() {
		// TODO Auto-generated method stub
		return 0;
	}

}
