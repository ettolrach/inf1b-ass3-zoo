package animals;

import areas.AreaType;

public class Parrot extends Animal {
    public Parrot(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.CAGE;
        this.incompatibles.add(AnimalSpecies.BUZZARD);
    }
}
