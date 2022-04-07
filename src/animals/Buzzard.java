package animals;

import areas.AreaType;

public class Buzzard extends Animal {
    public Buzzard(String nickname) {
        super(nickname);
        this.areaType = AreaType.CAGE;
        this.species = AnimalSpecies.BUZZARD;
        this.incompatibles.add(AnimalSpecies.PARROT);
    }
}
