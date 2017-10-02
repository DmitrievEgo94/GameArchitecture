import java.util.ArrayList;

public abstract class GameObject {

    private int id;
    private int health;
    private Resources cost;
    private long timeToBuild;

    GameObject(int id, int health, Resources cost, int timeToBuild) {
        this.health = health;
        this.id = id;
        this.cost = cost;
        this.timeToBuild = timeToBuild;
    }

    public int getId() {
        return id;
    }

    public Resources getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public long getTimeToBuild() {
        return timeToBuild;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;

        if (obj.getClass() != this.getClass()) return false;

        GameObject gameObject = (GameObject) obj;

        if (this.id == gameObject.id) return true;
        else return false;
    }
}
