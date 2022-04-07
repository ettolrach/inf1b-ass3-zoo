package areas;

public class Cage extends Area {
    public Cage(int maxCap) {
        super(maxCap);
        this.areaType = AreaType.CAGE;
    }
    public Cage(int maxCap, int id) {
        super(maxCap, id);
        this.areaType = AreaType.CAGE;
    }
}
