package animals;

import areas.AreaType;

public class Gazelle extends Animal {
    public Gazelle(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.ENCLOSURE;
        this.incompatibles.add(AnimalSpecies.LION);
    }
}
