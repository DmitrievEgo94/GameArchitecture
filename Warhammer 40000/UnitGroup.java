public abstract class UnitGroup extends GameObject {

    private int damagePerUnit;
    private int spiritPerUnit;
    private int sizeOfGroup;
    private int range;
    private int sizeOfGroupAfterCreation;

    /**
     * cells per second
     */
    private double speed;

    UnitGroup(int id, int health, Resources cost, int timeToBuild,
              int damagePerUnit, int spiritPerUnit, int sizeofGroup, int sizeOfGroupAfterCreation, int range, int speed) {
        super(id, health, cost, timeToBuild);
        this.damagePerUnit = damagePerUnit;
        this.spiritPerUnit = spiritPerUnit;
        this.sizeOfGroup = sizeofGroup;
        this.sizeOfGroupAfterCreation = sizeOfGroupAfterCreation;
        this.range = range;
        this.speed = speed;
    }

    public int getDamagePerUnit() {
        return damagePerUnit;
    }

    public int getSpiritPerUnit() {
        return spiritPerUnit;
    }

    public int getSizeOfGroup() {
        return sizeOfGroup;
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
}
