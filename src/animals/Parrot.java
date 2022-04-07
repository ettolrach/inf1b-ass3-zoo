package animals;

import areas.AreaType;

public class Parrot extends Animal {
    public Parrot(String nickname) {
        super(nickname);
        this.areaType = AreaType.CAGE;
        this.species = AnimalSpecies.PARROT;
        this.incompatibles.add(AnimalSpecies.BUZZARD);
    }
}
