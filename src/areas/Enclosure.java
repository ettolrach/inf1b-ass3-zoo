package areas;

public class Enclosure extends Area {
    public Enclosure(int maxCap) {
        super(maxCap);
        this.areaType = AreaType.ENCLOSURE;
    }
    public Enclosure(int id, int maxCap) {
        super(id, maxCap);
        this.areaType = AreaType.ENCLOSURE;
    }
}
