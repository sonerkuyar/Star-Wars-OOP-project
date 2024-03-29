
public interface IWarship {
	
    void addCrewman(Crewman crewman);
    void removeCrewman(Crewman crewman);
    void jumpToSector(Sector sector, int coordinate);
    int getPowerOutput();
    General getCommander();
    void upgradeArmament(int amount);
    void upgradeShield(int amount);
}

