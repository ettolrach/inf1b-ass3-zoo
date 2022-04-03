package animals;

import areas.AreaType;

public class Starfish extends Animal {
    public Starfish() {
        this.areaType = AreaType.AQUARIUM;
        this.incompatibles.add(AnimalSpecies.SHARK);
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
