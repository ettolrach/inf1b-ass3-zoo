package animals;

import areas.AreaType;

public class Buzzard extends Animal {
    public Buzzard() {
        this.areaType = AreaType.CAGE;
        this.incompatibles.add(AnimalSpecies.PARROT);
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
