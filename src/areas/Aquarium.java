package areas;

public class Aquarium extends Area {
    public Aquarium(int id, int maxCap) {
        super(id, maxCap);
        this.areaType = AreaType.AQUARIUM;
    }
}
