package gameobjects.core;


import gameobjects.imp.Resources;

import java.util.List;

public abstract class RaceBuilding extends GameObject {

    private List<UnitGroup> unitsAreAvailableToBeProduced;
    private Resources producingResourcesPerSecond;

    public RaceBuilding(int id, int health, Resources cost, int timeToBuild,
                        List<UnitGroup> unitsAreAvailableToBeProduced, Resources producingResourcesPerSecond) {
        super(id, health, cost, timeToBuild);
        this.unitsAreAvailableToBeProduced = unitsAreAvailableToBeProduced;
        this.producingResourcesPerSecond = producingResourcesPerSecond;
    }

    public Resources getProducingResourcesPerSecond() {
        return producingResourcesPerSecond;
    }

    public boolean isUnitAvailableBeProduced(UnitGroup newUnit) {
        if (unitsAreAvailableToBeProduced.contains(newUnit)) return true;
        else return false;
    }


}
