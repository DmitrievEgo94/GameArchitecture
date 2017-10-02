import java.util.Collections;
import java.util.List;

public abstract class Race {

    private List<RaceBuilding> raceBuildings;
    private List<UnitGroup> unitGroups;
    private Resources resourcesAtStart;
    private List<RaceBuilding> startBuildings;
    private List<UnitGroup> startUnits;

    Race(List<RaceBuilding> raceBuildings, List<UnitGroup> unitGroups) {
        this.raceBuildings = raceBuildings;
        this.unitGroups = unitGroups;
    }

    public List<RaceBuilding> getRaceBuildings() {
        return Collections.unmodifiableList(raceBuildings);
    }

    public List<UnitGroup> getUnitGroups() {
        return Collections.unmodifiableList(unitGroups);
    }
}
