

public class Events extends Main {
	
	
	
	public static void attack(String[] input) {
		int attackerId = Integer.parseInt(input[1]);
		int defenderId = Integer.parseInt(input[2]);
		//commanding generals will talk with each other
		Warship attacker = warshipArr.get(attackerId-1);
		Warship defender = warshipArr.get(defenderId-1);
		General attackerGen = attacker.getCommander();
		General defenderGen = defender.getCommander();
		
		//Attacker will jump to defenders sector
		int warSector = defender.currentSector.id;
		int attackerSector = attacker.currentSector.id;
		attacker.currentSector = sectorArr.get(warSector - 1);
		
		
		Warship republicWarship;
		Warship separatistWarship;
		Jedi generalJedi ;
		Sith generalSith;
		if(attackerGen instanceof Jedi && defenderGen instanceof Sith)
		{	
			republicWarship =attacker;
			separatistWarship = defender;
			generalJedi = ((Jedi)attackerGen);
			generalSith = ((Sith)defenderGen);
			
			
			
			
			
		}
		else{	
				republicWarship =defender;
				separatistWarship =attacker;
				generalJedi = ((Jedi) defenderGen);
				generalSith = ((Sith) attackerGen);
					
			}
		
		if((generalSith.persuasion- generalJedi.intelligence) >= generalJedi.sanity)
		{
			generalJedi.sanity = 0;
			//Jedi will betray and will kill all other crew in ship
			// cruiser will be destroyed by the separatist warship
			// betraying jedi commander will be kill by the Sith commander
			
			
			
		}
		else if (generalJedi.intelligence > generalSith.persuasion){
			//dont do anything
		}
		else {
			generalJedi.sanity += -(generalSith.persuasion-generalJedi.intelligence);
		}
		// Comparing the powers of warships
		if(generalJedi.sanity == 0) {
			//Jedi will betray and will kill all other crew in ship
			// cruiser will be destroyed by the separatist warship
			// betraying jedi commander will be kill by the Sith commander
			
			
			
		}
		else {
			if(republicWarship.getPowerOutput()> separatistWarship.getPowerOutput())
			{
				//republic destroy separatist warship
				// all officers in the separatist warship will be taken as caoitves to the republic warship
				for(Crewman captive:separatistWarship.crew)
				{
					if(captive instanceof Officer)
					{
						((RepublicCruiser)republicWarship).captives.add(captive);
						separatistWarship.crew.remove(captive);
					}
				}
			}
			else if (separatistWarship.getPowerOutput()> republicWarship.getPowerOutput())
			{
				//separatists destroy republic warship
			}
		}
		
				
			
			
		}
		
		
		
		
		
		
	
	public static void assault(String[] input) {
		
	}
	public static void jumpToSector(String[] input) {
		int warshipId = Integer.parseInt(input[1]);
		int sectorId = Integer.parseInt(input[2]);
		int coordinate = Integer.parseInt(input[3]);
		Warship w = warshipArr.get(warshipId-1);
		Sector s = sectorArr.get(sectorId-1);
		w.jumpToSector(s, coordinate);
		
		
	}
	public static void  visitCorousant(String[] input) {
		int cruiserId = Integer.parseInt(input[1]);
	
		Warship w = warshipArr.get(cruiserId-1);
		if (w instanceof RepublicCruiser) {
			RepublicCruiser r = (RepublicCruiser) w;
			r.visitCoruscant();
		}
		
		
		
	}
	public static void addCrewman(String[] input) {
		int crewmanId =  Integer.parseInt(input[1]);
		int warshipId = Integer.parseInt(input[2]);
		Warship w = warshipArr.get(warshipId - 1);
		Crewman c = crewmanArr.get(crewmanId-1);
		
		w.addCrewman(c);
		
	}
	public static void removeCrewman(String[] input) {
		int crewmanId =  Integer.parseInt(input[1]);
		int warshipId = Integer.parseInt(input[2]);
		Warship w = warshipArr.get(warshipId - 1 );
		Crewman c = crewmanArr.get(crewmanId-1);
		w.removeCrewman(c);
		
		
	}
	public static void trainOfficer(String[] input) {
		int officerId = Integer.parseInt(input[1]);
		Officer o = (Officer) crewmanArr.get(officerId-1);
		o.train();
		
		
	}
	public static void upgradeWarship(String[] input) {
		int warshipId = Integer.parseInt(input[1]);
		String key = input[2];
		int amount = Integer.parseInt(input[3]);
		Warship w = warshipArr.get(warshipId-1);
		if(key.equals("Armament")) {
			w.upgradeArmament(amount);
			
		}
		else if(key.equals("Shield"))
			w.upgradeShield(amount);
		
	}
	

}

