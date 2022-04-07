package animals;

import areas.AreaType;

public class Shark extends Animal {
    public Shark(String nickname) {
        super(nickname);
        this.areaType = AreaType.AQUARIUM;
        this.species = AnimalSpecies.SHARK;
        this.incompatibles.add(AnimalSpecies.SEAL);
    }
}
