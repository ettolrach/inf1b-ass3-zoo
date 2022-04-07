package animals;

import areas.AreaType;

public class Zebra extends Animal {
    public Zebra(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.ENCLOSURE;
        this.incompatibles.add(AnimalSpecies.LION);
    }
}
