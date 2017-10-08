package gameobjects.objectsonscene.impl;

import gameobjects.core.RaceBuilding;
import gameobjects.core.UnitGroup;
import gameobjects.imp.Resources;

import java.awt.*;

public class BuildingOnMap  {

    private RaceBuilding building;
    private Point position;

    BuildingOnMap(RaceBuilding building, Point position){
        this.building = building;
        this.position = position;
    }

    public UnitOnMap produceUnit(UnitGroup unit, Resources ownedResources){
        if (building.isUnitAvailableBeProduced(unit)&&ownedResources.compareTo(unit.getCost())>0){
            try {
                Thread.sleep(unit.getTimeToBuild());
            }catch (InterruptedException e){
                return null;
            }
            return new UnitOnMap(unit,new Point(position.x,position.y));
        }

        return null;
    }

    public Resources getProducedResources(){
       return building.getProducingResourcesPerSecond();
    }

    public Point getPosition(){
        return new Point(position.x, position.y);
    }

    public RaceBuilding getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;

        if (this.getClass()!=obj.getClass()) return false;

        BuildingOnMap buildingOnMap= (BuildingOnMap)obj;

        if (this.building.equals(buildingOnMap)&&(this.position.equals(buildingOnMap.position)))
            return true;
        else return false;
    }
}
