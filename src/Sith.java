
public class Sith extends General {
	/*
	* Necessary fields
	*/
	int persuasion;
	Affiliation affiliation;
	/*
	* Necessary methods
	*/
	public Sith(int id, String name, int experience, int midichlorian, int
	   persuasion) {
		super(id, name, experience, midichlorian);
		this.persuasion = persuasion;
		affiliation = Affiliation.SEPARATISTS;
//		TODO
	}
	@Override
	public int getForcePower() {
		// TODO Auto-generated method stub
		return 4*midichlorian;
	}
	@Override
	public int getCombatPower() {
		// TODO Auto-generated method stub
		return (getForcePower()+experience+persuasion);
	}

}
