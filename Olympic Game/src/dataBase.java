package Participants;

import java.util.ArrayList;

public class dataBase {
	public static ArrayList<Participant> cyclists=new ArrayList<Participant>();
	public static ArrayList<Participant> superAthletes=new ArrayList<Participant>();
	public static void setListOfCyclists(){
		cyclists.add(new Cyclist("c001", "cyclist1", 26, "VIC"));
		cyclists.add(new Cyclist("c002", "cyclist2", 26, "VIC"));
		cyclists.add(new Cyclist("c003", "cyclist3", 26, "VIC"));
		cyclists.add(new Cyclist("c004", "cyclist4", 26, "VIC"));
		cyclists.add(new Cyclist("c005", "cyclist5", 26, "VIC"));
		cyclists.add(new Cyclist("c006", "cyclist6", 26, "VIC"));
		cyclists.add(new Cyclist("c007", "cyclist7", 26, "VIC"));
		cyclists.add(new Cyclist("c008", "cyclist8", 26, "VIC"));
		cyclists.add(new Cyclist("c009", "cyclist9", 26, "VIC"));
	}	
	public static void setListOfSuperAthletes(){
		superAthletes.add(new superAthlete("su001", "superAthlete1", 26, "VIC"));
		superAthletes.add(new superAthlete("su002", "superAthlete2", 26, "VIC"));
		superAthletes.add(new superAthlete("su003", "superAthlete3", 26, "VIC"));
		superAthletes.add(new superAthlete("su004", "superAthlete4", 26, "VIC"));
		superAthletes.add(new superAthlete("su005", "superAthlete5", 26, "VIC"));
		superAthletes.add(new superAthlete("su006", "superAthlete6", 26, "VIC"));
		superAthletes.add(new superAthlete("su007", "superAthlete7", 26, "VIC"));
		superAthletes.add(new superAthlete("su008", "superAthlete8", 26, "VIC"));
		superAthletes.add(new superAthlete("su009", "superAthlete9", 26, "VIC"));
		superAthletes.add(new superAthlete("su010", "superAthlete10", 26, "VIC"));
	}
}
