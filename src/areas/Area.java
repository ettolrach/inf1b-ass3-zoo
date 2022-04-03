package areas;

import animals.Animal;
import java.util.ArrayList;

public abstract class Area implements IArea {
    protected AreaType areaType;
    protected ArrayList<Integer> adjacentAreas;
    protected int id;
    protected ArrayList<Animal> animals;
    protected int maxCapacity;
    protected int capacity;

    public Area(int id, int maximumCapacity) {
        this.id = id;
        this.maxCapacity = maximumCapacity;
        this.capacity = 0;
    }
    public Area(int id) {
        this.id = id;
        this.maxCapacity = Integer.MAX_VALUE;
        this.capacity = 0;
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
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public int getCurrentCapacity() {
        return capacity;
    }
    public void updateCurrentCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }
    public void addToCapacity(int dCapacity) {
        this.capacity += dCapacity;
    }
    public boolean isHabitat() {
        return this.areaType != AreaType.PICNIC && this.areaType != AreaType.ENTRANCE;
    }
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
