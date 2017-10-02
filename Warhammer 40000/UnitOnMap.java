import java.awt.*;

import static java.lang.Math.*;

public class UnitOnMap implements Movable,ObjectOnMap {

    private Point position;
    private UnitGroup unitGroup;
    private int currentNumberInGroup;
    private int currentSpirit;
    private int currentHealth;

    UnitOnMap(UnitGroup unitGroup, Point position) {
        this.unitGroup = unitGroup;
        this.position = position;
        this.currentNumberInGroup = unitGroup.getSizeOfGroupAfterCreation();
        this.currentHealth = unitGroup.getHealth() * currentNumberInGroup;
        this.currentSpirit = unitGroup.getSpiritPerUnit() * currentNumberInGroup;
    }

    @Override
    public long changePosition(Point newPosition) {

        long time = round((abs(newPosition.y - position.y) + abs(newPosition.x - position.x)) / unitGroup.getSpeed());
        this.position.x = newPosition.x;
        this.position.y = newPosition.y;

        return time;
    }

    synchronized public void attackUnit(UnitOnMap attackedUnit) {
        if (abs(this.position.x - attackedUnit.position.x) + abs(this.position.y - attackedUnit.position.y) < this.unitGroup.getRange()) {

            int spiritOfGroup = this.unitGroup.getSpiritPerUnit() * currentNumberInGroup;
            int damage = this.unitGroup.getDamagePerUnit() * this.currentNumberInGroup;
            attackedUnit.currentHealth -= damage * this.currentSpirit / spiritOfGroup;
            attackedUnit.currentSpirit -= damage * 0.5;

            if (attackedUnit.unitGroup.getHealth() * attackedUnit.currentNumberInGroup - currentHealth > attackedUnit.unitGroup.getHealth()) {
                attackedUnit.currentNumberInGroup--;
                attackedUnit.currentSpirit -= (attackedUnit.currentSpirit / spiritOfGroup) * attackedUnit.unitGroup.getSpiritPerUnit();
            }
        }
    }

    synchronized public void attackBuilding(BuildingOnMap attackedBuilding) {
        if (abs(this.position.x - attackedBuilding.getPosition().x) +
                abs(this.position.y - attackedBuilding.getPosition().y) < this.unitGroup.getRange()) {
            int spiritOfGroup = this.unitGroup.getSpiritPerUnit() * currentNumberInGroup;
            int damage = this.unitGroup.getDamagePerUnit() * this.currentNumberInGroup*this.currentSpirit / spiritOfGroup;
            int newHealth = attackedBuilding.getCurrentHealth()-damage;
            attackedBuilding.setCurrentHealth(newHealth);
        }

    }

    synchronized public boolean isDestroyed(){
        if (currentHealth<=0)
            return true;
        else return false;
    }

    synchronized public void restoreSpitit() {
        currentSpirit++;
    }
}
