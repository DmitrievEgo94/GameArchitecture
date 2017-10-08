package gameobjects.core;

import gameobjects.imp.Resources;

public abstract class UnitGroup extends GameObject {

    private int damagePerUnit;
    private int spiritPerUnit;
    private int sizeOfGroup;
    private int healthPerUnit;
    private Resources costPerUnit;
    private int range;
    private int sizeOfGroupAfterCreation;
    private int currentSpirit;
    private int maxNumerInGroup;

    /**
     * cells per second
     */
    private double speed;

    public UnitGroup(int id, Resources cost, int timeToBuild,
              int damagePerUnit, int spiritPerUnit, int sizeofGroup, int sizeOfGroupAfterCreation,
                     int range, int speed, int healthPerUnit,Resources costPerUnit, int maxNumerInGroup) {
        super(id, healthPerUnit * sizeofGroup, cost, timeToBuild);
        this.damagePerUnit = damagePerUnit;
        this.spiritPerUnit = spiritPerUnit;
        this.sizeOfGroup = sizeofGroup;
        this.healthPerUnit = healthPerUnit;
        this.sizeOfGroupAfterCreation = sizeOfGroupAfterCreation;
        this.range = range;
        this.speed = speed;
        this.currentSpirit = sizeofGroup * spiritPerUnit;
        this.costPerUnit = costPerUnit;
        this.maxNumerInGroup = maxNumerInGroup;
    }

    public int getRange() {
        return range;
    }

    public double getSpeed() {
        return speed;
    }

    public int getSizeOfGroupAfterCreation() {
        return sizeOfGroupAfterCreation;
    }

    public int getDamage(){
        return damagePerUnit*sizeOfGroup*currentSpirit/(spiritPerUnit*sizeOfGroup);
    }

    public void changeSizeOfGroupAfterDamage(){
        if (sizeOfGroup*healthPerUnit-getHealth()>healthPerUnit){
            sizeOfGroup--;
            currentSpirit-=spiritPerUnit;
        }
    }

    public boolean increaseSizeOfGroup(Resources ownedResources){
        if (ownedResources.compareTo(costPerUnit)>0) {
            sizeOfGroup++;
            ownedResources.add(new Resources(-costPerUnit.getInfluence(),-costPerUnit.getEnergy()));
            return true;
        }
        return false;
    }

    public void restoreSpitit() {
        currentSpirit++;
    }

    abstract boolean ability(UnitGroup unit);
}
