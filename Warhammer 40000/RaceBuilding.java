import java.util.List;

public abstract class RaceBuilding extends GameObject {

    private List<UnitGroup> producedUnites;
    private Resources producedResources;

    public RaceBuilding(int id, int health, Resources cost, int timeToBuild,
                        List<UnitGroup> producedUnites, Resources producedResources) {
        super(id, health, cost, timeToBuild);
        this.producedUnites = producedUnites;
        this.producedResources = producedResources;
    }

    public Resources getProducedResources() {
        return producedResources;
    }

    public boolean isUnitAvailableBeProduced(UnitGroup newUnit) {
        if (producedUnites.contains(newUnit)) return true;
        else return false;
    }
}
