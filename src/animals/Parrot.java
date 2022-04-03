package animals;

import areas.AreaType;

public class Parrot extends Animal {
    public Parrot() {
        this.areaType = AreaType.CAGE;
        this.incompatibles.add(AnimalSpecies.BUZZARD);
    }
}
