package animals;

import areas.AreaType;

public class Buzzard extends Animal {
    public Buzzard(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.CAGE;
        this.incompatibles.add(AnimalSpecies.PARROT);
    }
}
