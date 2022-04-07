package areas;

public class Enclosure extends Area {
    public Enclosure(int maxCap) {
        super(maxCap);
        this.areaType = AreaType.ENCLOSURE;
    }
    public Enclosure(int maxCap, int id) {
        super(maxCap, id);
        this.areaType = AreaType.ENCLOSURE;
    }
}
