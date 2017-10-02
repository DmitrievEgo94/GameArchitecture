public class Resources implements Comparable<Resources>  {

    private int energy;
    private int influence;

    public Resources(int energy, int influence){
        this.energy=energy;
        this.influence=influence;
    }

    @Override
    public int compareTo(Resources o) {
        if ((this.energy > o.energy) & (this.influence > o.influence))
            return 1;
        else if ((this.energy < o.energy) & (this.influence < o.influence))
            return -1;
        else return 0;
    }

    public void add(Resources resources){
        this.energy+=resources.energy;
        this.influence+=resources.influence;
    }

    public int getEnergy() {
        return energy;
    }

    public int getInfluence() {
        return influence;
    }
}
