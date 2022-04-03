package animals;

import areas.AreaType;

public class Starfish extends Animal {
    public Starfish() {
        this.areaType = AreaType.AQUARIUM;
        this.incompatibles.add(AnimalSpecies.SHARK);
    }
}
