package animals;

import areas.AreaType;

public class Seal extends Animal {
    public Seal(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.AQUARIUM;
        this.incompatibles.add(AnimalSpecies.SHARK);
    }
}
