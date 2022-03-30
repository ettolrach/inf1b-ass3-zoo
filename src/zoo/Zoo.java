package zoo;

import animals.Animal;
import areas.Area;
import areas.AreaType;
import areas.Entrance;
import areas.IArea;
import dataStructures.ICashCount;

import java.util.ArrayList;
import java.util.Set;

public class Zoo implements IZoo {
    private ArrayList<Area> areas;

    public Zoo() {
        this.areas = new ArrayList<Area>();
        this.areas.add(new Entrance(0));
    }
    public int addArea(IArea area) {
        // This type conversion *should* be safe, since the only way to declare an Area
        // object is by making it an Area, not an IArea.
        if (this.areas.contains(area) || ((Area)area).getAreaType() == AreaType.ENTRANCE) {
            return -1;
        }
        return this.areas.get(this.areas.indexOf(area)).getId();
    }
    
    public boolean removeArea(int areaId) {
        for (Area area : this.areas) {
            if (area.getId() == areaId) {
                this.areas.remove(area);
                return true;
            }
        }
        return false;
    }
    
    public IArea getArea(int areaId) {
        for (Area area : this.areas) {
            if (area.getId() == areaId) {
                return area;
            }
        }
        return null;
    }
    
    public byte addAnimal(int areaId, Animal animal) {
        return 0;
    }
    //-----------intermediate
    public void connectAreas(int fromAreaId, int toAreaId) {

    }

    public boolean isPathAllowed(ArrayList<Integer> areaIds) {
        return false;
    }
    
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) {
        return null;
    }

    public Set<Integer> findUnreachableAreas() {
        return null;
    }
    
    public void setEntranceFee(int pounds, int pence) {

    }

    
    public void setCashSupply(ICashCount coins) {

    }

    public ICashCount getCashSupply() {
        return null;
    }
    
    public ICashCount payEntranceFee(ICashCount cashInserted) {
        return null;
    }
}
