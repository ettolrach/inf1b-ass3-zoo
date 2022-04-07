package areas;

public class Cage extends Area {
    public Cage(int maxCap) {
        super(maxCap);
        this.areaType = AreaType.CAGE;
    }
    public Cage(int id, int maxCap) {
        super(id, maxCap);
        this.areaType = AreaType.CAGE;
    }
}
