import java.awt.*;
import java.util.List;

public class Player {

    private Race race;
    private Resources ownedResources;
    private List<UnitOnMap> availableUnits;
    private List<BuildingOnMap> availableBuildings;

    Player(Race race, Resources ownedResources, List<UnitOnMap> availableUnits, List<BuildingOnMap> availableBuildings) {
        this.availableBuildings = availableBuildings;
        this.ownedResources = ownedResources;
        this.availableUnits = availableUnits;
        this.availableBuildings = availableBuildings;
    }

    synchronized public void produceResources(){
        for (;;)
        for (BuildingOnMap building:availableBuildings)
            ownedResources.add(building.getProducedResources());
    }
}
