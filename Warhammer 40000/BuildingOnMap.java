import java.awt.*;

public class BuildingOnMap implements ObjectOnMap {

    private RaceBuilding building;
    private Point position;
    private int currentHealth;

    BuildingOnMap(RaceBuilding building, Point position, int currentHealth){
        this.building = building;
        this.position = position;
        this.currentHealth=currentHealth;
    }

    synchronized public UnitOnMap produceUnit(UnitGroup unit, Resources ownedResources){
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
       return building.getProducedResources();
    }

    public Point getPosition(){
        return new Point(position.x, position.y);
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    synchronized public boolean isDestroyed(){
        if (currentHealth<=0)
            return true;
        else return false;
    }
}
