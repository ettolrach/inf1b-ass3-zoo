package zoo;

import animals.Animal;
import areas.Area;
import areas.AreaType;
import areas.Entrance;
import areas.IArea;
import dataStructures.ICashCount;

import java.util.*;

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
        this.areas.add(aArea);
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
        Area fromArea = (Area)this.getArea(fromAreaId);
        if (fromArea == null) {
            throw new NoSuchElementException("No area with such ID.");
        }
        fromArea.addAdjacentArea(toAreaId);
    }

    public boolean isPathAllowed(ArrayList<Integer> areaIds) {
        // Assume that the identity is true, as in, not moving returns true.
        boolean isAllowed = true;
        // For each element starting with the 2nd, check if the previous element connects with it.
        // By making use of the AND operator, a single FALSE will negate the whole sequence, as desired.
        for (int i = 1; i < areaIds.size(); i++) {
            isAllowed = isAllowed && this.getArea(areaIds.get(i-1)).getAdjacentAreas().contains(areaIds.get(i));
        }
        return isAllowed;
    }
    
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) {
        Area area;
        ArrayList<Animal> animalsInArea;
        if (!isPathAllowed(areaIdsVisited)) {
            return null;
        }
        ArrayList<String> listOfNames = new ArrayList<>();
        // Get each area specified by the given IDs.
        for (int areaId : areaIdsVisited) {
            area = (Area)getArea(areaId);
            // Then get all the animals in the area.
            animalsInArea = area.getAnimals();
            // Add each animal's name to listOfNames.
            for (Animal animal : animalsInArea) {
                listOfNames.add(animal.getNickname());
            }
        }
        return listOfNames;
    }

    public Set<Integer> getReachableAreas(int areaId, Set<Integer> previousIds) {
        previousIds.add(areaId);
        // Get all of the adjacent areas' IDs.
        ArrayList<Integer> reachableAreas = this.getArea(areaId).getAdjacentAreas();
        // Convert the received list to a set.
        Set<Integer> reachableIds = new HashSet<>(reachableAreas);
        // Only look at the areas that weren't checked yet.
        reachableIds.removeAll(previousIds);
        // Check for any new adjacent areas.
        for (Integer reachable : reachableIds) {
            reachableIds.addAll(getReachableAreas(reachable, previousIds));
        }
        return reachableIds;
    }

    public Set<Integer> findUnreachableAreas() {
        Set<Integer> reachables = getReachableAreas(0, new HashSet<>());
        reachables.add(0);
        Set<Integer> unreachables = new HashSet<>();
        for (Area a : this.areas) {
            if (!reachables.contains(a.getId())) {
                unreachables.add(a.getId());
            }
        }
        return unreachables;
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
