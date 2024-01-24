
public abstract class General extends Crewman implements IForceUser{
	/*
	* Necessary fields
	*/
	int experience;
	int midichlorian;
	/*
	* Necessary methods
	*/
	protected General() {
//		TODO
	}
	public General(int id, String name, int experience , int midichlorian) {
		super(id, name);
		this.midichlorian = midichlorian;
		this.experience  = experience;
		
//		TODO
	}
	

}
