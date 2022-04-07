package animals;

import areas.AreaType;

public class Starfish extends Animal {
    public Starfish(String nickname) {
        super(nickname);
        this.areaType = AreaType.AQUARIUM;
        this.species = AnimalSpecies.STARFISH;
    }
}
