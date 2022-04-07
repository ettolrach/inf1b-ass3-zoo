package areas;

import animals.Animal;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Area implements IArea {
    protected AreaType areaType;
    protected ArrayList<Integer> adjacentAreas;
    protected int id;
    protected ArrayList<Animal> animals;
    protected int maxCapacity;
    protected int capacity;

    public Area(int maximumCapacity, int id) {
        this.id = id;
        this.maxCapacity = maximumCapacity;
        this.capacity = 0;
        this.adjacentAreas = new ArrayList<>();
        this.animals = new ArrayList<>();
    }
    public Area(int maximumCapacity) {
        this.maxCapacity = maximumCapacity;
        this.capacity = 0;
        this.adjacentAreas = new ArrayList<>();
        this.animals = new ArrayList<>();
        // Generate a random ID. It is unlikely, but possible, to be a duplicate.
        this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }
    public Area() {
        this.maxCapacity = Integer.MAX_VALUE;
        this.capacity = 0;
        this.adjacentAreas = new ArrayList<>();
        this.animals = new ArrayList<>();
        // Generate a random ID. It is unlikely, but possible, to be a duplicate.
        this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
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
