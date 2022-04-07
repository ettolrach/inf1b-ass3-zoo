package areas;

public class Aquarium extends Area {
    public Aquarium(int maxCap) {
        super(maxCap);
        this.areaType = AreaType.AQUARIUM;
    }
    public Aquarium(int maxCap, int id) {
        super(maxCap, id);
        this.areaType = AreaType.AQUARIUM;
    }
}
