
public class Officer extends Crewman {
	
	int intrinsicLevel;
	Intrinsic intrinsic;
	/*
	* Necessary methods
	*/
	public Officer(int id, String name, Intrinsic intrinsic, int intrinsicLevel)
	{
   //		TODO
		super(id, name);
		this.intrinsicLevel = intrinsicLevel;
		this.intrinsic = intrinsic;
		
		// fix about the intrinsic
	}
	public void train() {
		if(intrinsicLevel < 10)
			intrinsicLevel++;
//		TODO
		
	}

}
