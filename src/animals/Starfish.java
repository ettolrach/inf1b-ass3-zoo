package animals;

import areas.AreaType;

public class Starfish extends Animal {
    public Starfish(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.AQUARIUM;
        this.incompatibles.add(AnimalSpecies.SHARK);
    }
}
