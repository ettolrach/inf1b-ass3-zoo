package animals;

import areas.AreaType;

public class Zebra extends Animal {
    public Zebra(String nickname) {
        super(nickname);
        this.areaType = AreaType.ENCLOSURE;
        this.species = AnimalSpecies.ZEBRA;
        this.incompatibles.add(AnimalSpecies.LION);
    }
}
