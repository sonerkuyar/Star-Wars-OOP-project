
public class Jedi extends General{
	/*
	* Necessary fields
	*/
	Affiliation affiliation;
	int sanity;
	int intelligence;
	/*
	* Necessary methods
	*/
	public Jedi(int id, String name, int experience, int midichlorian, int
	intelligence) {
//		TODOs
		super(id, name, experience, midichlorian);
		this.intelligence = intelligence;
		//default values of sanity is 100
		sanity = 100;
		affiliation = Affiliation.REPUBLIC;
	}
	
	@Override
	public int getCombatPower() {
		// TODO Auto-generated method stub
		return (getForcePower()+experience+(sanity-100)+intelligence);
	}

	@Override
	public int getForcePower() {
		// TODO Auto-generated method stub
		return midichlorian*3;
	}

}
