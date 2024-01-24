import java.util.ArrayList;
import java.util.Hashtable;

public class SeparatistDestroyer extends Warship {
	/*
	* Necessary fields
	*/
	int escapePods;
	/*
	* Necessary methods
	*/
	protected SeparatistDestroyer() {
		
	}
	public SeparatistDestroyer(int id, String name, Sector currentSector, int
	   coordinate, ArrayList<Crewman> crew) {
		super(id, name, currentSector, coordinate, crew);
		escapePods = 1;
		armamentPower = 80;
		shieldPower = 60;
		crewCapacity = 7;
//		TODO
	}
	@Override
	public void addCrewman(Crewman crewman) {
		// TODO Auto-generated method stub
		if(crewman.isFree && crew.size() < crewCapacity && !(crewman instanceof Jedi)) {
			int beforeCrew = getPowerOutput();
			crew.add(crewman);
			if(beforeCrew >= getPowerOutput()) {
				crew.remove(-1); 
			}
			
			
			
		}
		
	}
	@Override
	public void removeCrewman(Crewman crewman) {
		// TODO Auto-generated method stub
		for(Crewman searchCrewman: crew) {
			if(searchCrewman.id == crewman.id) {
				crew.remove(searchCrewman);
			}
		}
		
	}
	@Override
	public void jumpToSector(Sector sector, int coordinate) {
		// TODO Auto-generated method stub
		currentSector = sector;
		this.coordinate = coordinate;
		
	}
	@Override
	public int getPowerOutput() {
		// TODO Auto-generated method stub
		int genCon = 0;
		int offCon = 1;
		int sectorBuff = 2;
		if(currentSector.affiliation == Affiliation.SEPARATISTS)
		{
			sectorBuff = 3;
		}
		for(Crewman general: crew ) {
			if(general instanceof Jedi) {
				genCon += ((Jedi) general).getCombatPower();
			}
			}
		Hashtable<Intrinsic, Integer> maxDict = new Hashtable<Intrinsic,Integer>();
		
		for(Crewman officer: crew) {
			if(officer instanceof Officer) {
				Officer castedOfficer = (Officer)officer;
				if(!maxDict.containsKey(castedOfficer.intrinsic)) {
					maxDict.put(castedOfficer.intrinsic, castedOfficer.intrinsicLevel);
					
					
				}
				else {
					if (castedOfficer.intrinsicLevel > maxDict.get(castedOfficer.intrinsic)) {
						maxDict.put(castedOfficer.intrinsic,castedOfficer.intrinsicLevel);
						
					}
				}
				
				
			}
		}
		
		for(Integer value: maxDict.values()) {
			offCon *= (1+value);
		}
		// calculating the general formula
		
		return sectorBuff*(armamentPower+shieldPower+genCon+offCon);
		
	}
	@Override
	public General getCommander() {
		// TODO Auto-generated method stub
		// take the biggest combat power if equal look the min id
		int maxPower = 0;
		int commanderId = 0;
		for(Crewman isCommander: crew) {
			if(isCommander instanceof Sith) {
				if(((Sith) isCommander).getCombatPower() > maxPower) {
					commanderId = isCommander.id;
					
				}
				else if (((Sith) isCommander).getCombatPower() == maxPower)
				{
					if(commanderId >isCommander.id)
						commanderId = isCommander.id;
				}
			}
			
		}
		return (General) Main.crewmanArr.get(commanderId-1);
	}
	@Override
	public void upgradeArmament(int amount) {
		// TODO Auto-generated method stub
		armamentPower +=amount;
		
	}
	@Override
	public void upgradeShield(int amount) {
		
		// TODO Auto-generated method stub
		shieldPower += amount;
		
	}

}
