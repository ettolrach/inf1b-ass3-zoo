package animals;

import areas.AreaType;

public class Zebra extends Animal {
    public Zebra() {
        this.areaType = AreaType.ENCLOSURE;
        this.incompatibles.add(AnimalSpecies.LION);
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
