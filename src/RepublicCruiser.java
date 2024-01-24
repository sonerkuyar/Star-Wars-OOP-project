import java.util.ArrayList;
import java.util.Hashtable;

public class RepublicCruiser extends Warship {
	/*
	* Necessary fields
	*/
	ArrayList<Crewman> captives;
	/*
	* Necessary methods
	*/
	public RepublicCruiser(int id, String name, Sector currentSector, int coordinate
	, ArrayList<Crewman> crew) {
		super(id, name, currentSector, coordinate, crew);
		armamentPower = 100;
		shieldPower = 100;
		crewCapacity = 10;
		
		
	}
	//CLASS METHOD
	public void visitCoruscant() {
		for(Crewman captive: captives) {
			captive.imprisoned = true;
			captive.isFree =false;
		}
		for(Crewman isJedi: crew) {
			if(isJedi instanceof Jedi) {
				((Jedi) isJedi).sanity = 100;
			}
		}
//		TODO
	}
	@Override
	public void addCrewman(Crewman crewman) {
		
		if(crewman.isFree) {
			//if there is enough space get the crewman to the ship
			if(crew.size() < crewCapacity && !(crewman instanceof Sith)) {
				crew.add(crewman);
			}
			
		}
		else {
			//dont do anything
		}
		// TODO Auto-generated method stub
		
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
		if(currentSector.affiliation == Affiliation.REPUBLIC)
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
		//take the most experienced commander if equal look lower id
		
		int max_experience = 0;
		int commanderId = 0;
		for(Crewman isCommander: crew) {
			if(isCommander instanceof Jedi) {
				if(((Jedi) isCommander).experience > max_experience)
				{
					commanderId = isCommander.id;
					
				}
				else if(((Jedi) isCommander).experience == max_experience)
				{
					if(commanderId > isCommander.id)
						commanderId = isCommander.id;
				}
				
			}
		}
		return (General) Main.crewmanArr.get(commanderId -1);
	}
	@Override
	public void upgradeArmament(int amount) {
		// TODO Auto-generated method stub
		armamentPower+= amount;
		
	}
	@Override
	public void upgradeShield(int amount) {
		// TODO Auto-generated method stub
		shieldPower += amount;
	}

}
