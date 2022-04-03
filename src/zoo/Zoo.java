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
        Area aArea;
        // Check if the IArea is also an Area object, and if not, return -1.
        if (!(area instanceof Area)) {
            return -1;
        }
        // This type conversion *should* always work, since the only way to declare an Area
        // object is by making it an Area, not an IArea. If it doesn't work, this will be
        // caught by the above if block.
        aArea = (Area)area;

        // If the area ID has already been added, then don't add it.
        for (Area currentArea : this.areas) {
            if (currentArea.getId() == aArea.getId()) {
                return -1;
            }
        }

        return aArea.getId();
    }
    
    public boolean removeArea(int areaId) {
        // Don't remove the entrance area.
        if (areaId == 0) {
            return false;
        }
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
        // As mentioned previously, this type conversion should be safe.
        Area area = ((Area)(getArea(areaId)));

        // Not using 'else if' is okay here because all of them return a value.
        if (!area.isHabitat()) {
            return Codes.NOT_A_HABITAT;
        }
        // Check if the animal can live in the area.
        if (area.getAreaType() != animal.getHabitat()) {
            return Codes.WRONG_HABITAT;
        }
        if (area.getCurrentCapacity() >= area.getMaxCapacity()) {
            return Codes.HABITAT_FULL;
        }
        for (Animal areaAnimal : area.getAnimals()) {
            if (!areaAnimal.isCompatibleWith(animal)) {
                return Codes.INCOMPATIBLE_INHABITANTS;
            }
        }
        area.addAnimal(animal);
        return Codes.ANIMAL_ADDED;
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
