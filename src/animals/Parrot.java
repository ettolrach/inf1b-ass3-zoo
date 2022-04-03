package animals;

import areas.AreaType;

public class Parrot extends Animal {
    public Parrot() {
        this.areaType = AreaType.CAGE;
        this.incompatibles.add(AnimalSpecies.BUZZARD);
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
