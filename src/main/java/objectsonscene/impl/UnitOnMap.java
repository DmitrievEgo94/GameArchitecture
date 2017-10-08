package objectsonscene.impl;


import gameobjects.core.RaceBuilding;
import gameobjects.core.UnitGroup;
import objectsonscene.core.Movable;

import java.awt.*;

import static java.lang.Math.*;

public class UnitOnMap implements Movable {

    private Point position;
    private UnitGroup unitGroup;

    public UnitOnMap(UnitGroup unitGroup, Point position) {
        this.unitGroup = unitGroup;
        this.position = position;
    }

    @Override
    public long changePosition(Point newPosition) {
        long time = Math.round((abs(newPosition.y - position.y) + abs(newPosition.x - position.x)) / unitGroup.getSpeed());
        this.position.x = newPosition.x;
        this.position.y = newPosition.y;

        return time;
    }

    public void attackUnit(UnitOnMap attackedUnitOnMap) {
        UnitGroup controlledUnit = this.unitGroup;
        UnitGroup attackedUnit = attackedUnitOnMap.getUnitGroup();

        if (abs(this.position.x - attackedUnitOnMap.position.x) + abs(this.position.y - attackedUnitOnMap.position.y) <
                this.unitGroup.getRange()) {

            attackedUnit.setHealth(attackedUnit.getHealth() - controlledUnit.getDamage());

            attackedUnit.changeSizeOfGroupAfterDamage();
        }
    }

    public UnitGroup getUnitGroup() {
        return unitGroup;
    }

    public void attackBuilding(BuildingOnMap attackedBuildingOnMap) {
        UnitGroup controlledUnit = this.unitGroup;
        RaceBuilding attackedBuilding = attackedBuildingOnMap.getBuilding();

        if (abs(this.position.x - attackedBuildingOnMap.getPosition().x) +
                abs(this.position.y - attackedBuildingOnMap.getPosition().y) < this.unitGroup.getRange()) {

            attackedBuilding.setHealth(attackedBuilding.getHealth()-controlledUnit.getDamage());
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (this.getClass() != obj.getClass()) return false;

        UnitOnMap unitOnMap = (UnitOnMap) obj;

        if (this.unitGroup.equals(unitOnMap) && (this.position.equals(unitOnMap.position)))
            return true;
        else return false;
    }
}
