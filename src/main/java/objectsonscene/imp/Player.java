package objectsonscene.imp;


import gameobjects.core.Race;
import gameobjects.core.UnitGroup;
import gameobjects.imp.Resources;
import objectsonscene.core.PlayerActions;

import java.awt.*;
import java.util.List;

public class Player implements PlayerActions {

    private Race race;
    private Resources ownedResources;
    private List<UnitOnMap> availableUnits;
    private List<BuildingOnMap> availableBuildings;

    Player(Race race, List<UnitOnMap> availableUnits, List<BuildingOnMap> availableBuildings) {
        this.race=race;
        this.availableBuildings = availableBuildings;
        this.ownedResources = race.getResourcesAtStart();
        this.availableUnits = availableUnits;
        this.availableBuildings = availableBuildings;
    }

    public void produceResources(){
        for (;;)
        for (BuildingOnMap building:availableBuildings)
            ownedResources.add(building.getProducedResources());
    }

    @Override
    public UnitOnMap chooseBuildingToProduceUnit(BuildingOnMap building, UnitGroup unit) {
        if (!availableBuildings.contains(building))return null;

        return building.produceUnit(unit,this.ownedResources);
    }

    @Override
    public boolean moveUnitOnMap(UnitOnMap unit, Point newPosition) {
        if (!availableUnits.contains(unit)) return false;

        long time=unit.changePosition(newPosition);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean increaseSizeOfUnitGroup(UnitOnMap unit) {
        if (!availableUnits.contains(unit)) return false;

        return unit.getUnitGroup().increaseSizeOfGroup(ownedResources);
    }


}
