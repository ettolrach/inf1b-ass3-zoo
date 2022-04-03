package areas;

public class Cage extends Area {
    public Cage(int id, int maxCap) {
        super(id, maxCap);
        this.areaType = AreaType.CAGE;
    }
}
