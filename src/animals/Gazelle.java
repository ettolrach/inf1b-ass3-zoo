package animals;

import areas.AreaType;

public class Gazelle extends Animal {
    public Gazelle() {
        this.areaType = AreaType.ENCLOSURE;
        this.incompatibles.add(AnimalSpecies.LION);
    }
}
