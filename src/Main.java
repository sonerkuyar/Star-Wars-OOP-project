import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	public static ArrayList<Sector> sectorArr ;
	public static ArrayList<Crewman> crewmanArr;
	public static ArrayList<Warship> warshipArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		      File myObj = new File("input.txt");
		      Scanner myReader = new Scanner(myObj);
		      // taking sector input
		       sectorArr = new ArrayList<>();
		  	   crewmanArr = new ArrayList<>();
		  	   warshipArr = new ArrayList<>();
		      int sector_num = myReader.nextInt();
		      myReader.nextLine();
		      for(int i = 0; i< sector_num;i++)
		      {
		    	  String[] curr_sector = (myReader.nextLine()).split(" ");
		    	  
		    	  Sector s = new Sector(i+1, curr_sector[0],Affiliation.valueOf(curr_sector[1]));
		    	  sectorArr.add(s);
		    	  
		    	  
		      }
		      // taking crewman inputs
		      
		      int crewman_num = myReader.nextInt();
		      myReader.nextLine();
		      for(int i = 0; i< crewman_num;i++)
		      {
		    	  String[] curr_crewman = (myReader.nextLine()).split(" ");
		    	  if(curr_crewman[0].equals("Officer")) {
		    		  Crewman c = new Officer(i+1, curr_crewman[1],Intrinsic.valueOf(curr_crewman[2]), Integer.parseInt(curr_crewman[3]));
		    		  crewmanArr.add(c);
		    		  
		    	  }
		    	  else if (curr_crewman[0].equals("Jedi")) {
		    		  Crewman c = new Jedi(i+1, curr_crewman[1],Integer.parseInt(curr_crewman[2]) , Integer.parseInt(curr_crewman[3]), Integer.parseInt(curr_crewman[4]));
		    		  crewmanArr.add(c);
		    	  }
		    	  else if(curr_crewman[0].equals("Sith")) {
		    		  Crewman c = new Sith(i+1,curr_crewman[1],Integer.parseInt(curr_crewman[2]) , Integer.parseInt(curr_crewman[3]), Integer.parseInt(curr_crewman[4]));
		    		  crewmanArr.add(c);
		    	  }
		    	  
		      }
		      //taking warship inputs
		      
		      int warship_num = myReader.nextInt();
		      myReader.nextLine();
		      for(int i = 0; i< warship_num;i++)
		      {
		    	  String[] firstLine = (myReader.nextLine().split(" ")); 
		    	  String name = firstLine[1];
		    	  int currSectorId = Integer.parseInt(firstLine[2]);
		    	  int coordinate = Integer.parseInt(firstLine[3]);
		    	  String[] secondLine = (myReader.nextLine().split(" "));
		    	  int crewSize = Integer.parseInt(secondLine[0]);
		    	  ArrayList<Crewman> crew = new ArrayList<>();
		    	  for(int j = 0; j < crewSize; j++) {
		    		   int crewmanId = Integer.parseInt(secondLine[1+j]);
		    		   crewmanArr.get(crewmanId-1).isFree = false;
		    		   crew.add(crewmanArr.get(crewmanId - 1));
		    	  }
		    	  
		    	  if(firstLine[0].equals("RepublicCruiser")) {
		    		  Warship w = new RepublicCruiser(i, name, sectorArr.get(currSectorId-1), coordinate, crew);
		    		  warshipArr.add(w);
		    		  
		    	  }
		    	  else if(firstLine[0].equals("SeparatistBattleship")) {
		    		  Warship w = new SeparatistBattleship(i, name, sectorArr.get(currSectorId-1), coordinate, crew);
		    		  warshipArr.add(w);
		    		  
		    		  
		    	  }
		    	  else if(firstLine[0].equals("SeparatistDestroyer")) {
		    		  Warship w = new SeparatistDestroyer(i, name, sectorArr.get(currSectorId-1), coordinate, crew);
		    		  warshipArr.add(w);
		    		  
		    	  }
		    	  else if(firstLine[0].equals("SeparatistFrigate")) {
		    		  Warship w = new SeparatistFrigate(i, name, sectorArr.get(currSectorId-1), coordinate, crew);
		    		  warshipArr.add(w);
		    		  
		    		  
		    	  }
		    	  
		      }
		      
		      //taking events input
		      ArrayList<String[]> eventArr = new ArrayList<>();
		      int event_num = myReader.nextInt();
		      myReader.nextLine();
		      for(int i = 0; i< event_num;i++)
		      {
		    	  
		    	  eventArr.add(myReader.nextLine().split(" "));
		    	  
		      }
		      
		      myReader.close();
		      
		      // implementing events 
		      for(String[] event: eventArr) {
		    	  int eventCode = Integer.parseInt(event[0]);
		    	  if(eventCode == 10)
		    		  Events.attack(event);
		    	  else if(eventCode  == 11)
		    		  Events.assault(event);
		    	  else if(eventCode  == 20)
		    		  Events.jumpToSector(event);
		    	  else if(eventCode  == 30)
		    		  Events.visitCorousant(event);
		    	  else if(eventCode  == 40)
		    		  Events.addCrewman(event);
		    	  else if(eventCode  == 41)
		    		  Events.removeCrewman(event);
		    	  else if(eventCode == 50)
		    		  Events.trainOfficer(event);
		    	  else if(eventCode  == 51)
		    		  Events.upgradeWarship(event);
		    	  
		    	  
		      }
		
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	

}
