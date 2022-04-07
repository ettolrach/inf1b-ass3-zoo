package animals;

import areas.AreaType;

public class Gazelle extends Animal {
    public Gazelle(String nickname) {
        super(nickname);
        this.areaType = AreaType.ENCLOSURE;
        this.species = AnimalSpecies.GAZELLE;
        this.incompatibles.add(AnimalSpecies.LION);
    }
}
