package animals;

import areas.AreaType;

public class Seal extends Animal {
    public Seal(String nickname) {
        super(nickname);
        this.areaType = AreaType.AQUARIUM;
        this.species = AnimalSpecies.SEAL;
        this.incompatibles.add(AnimalSpecies.SHARK);
    }
}
