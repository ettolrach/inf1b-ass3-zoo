package areas;

import java.util.ArrayList;

public abstract class Area implements IArea {
    protected AreaType areaType;
    protected ArrayList<Integer> adjacentAreas;
    protected int id;

    public Area(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getAdjacentAreas() {
        return adjacentAreas;
    }
    public void addAdjacentArea(int areaId) {
        this.adjacentAreas.add(areaId);
    }
    public void removeAdjacentArea(int areaId) {
        this.adjacentAreas.remove(areaId);
    }
    public int getId() {
        return this.id;
    }
    public AreaType getAreaType() {
        return this.areaType;
    }
}
