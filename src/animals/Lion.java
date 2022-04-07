package animals;

import areas.AreaType;

public class Lion extends Animal {
    public Lion(String nickname) {
        super(nickname);
        this.areaType = AreaType.ENCLOSURE;
        this.species = AnimalSpecies.LION;
        this.incompatibles.add(AnimalSpecies.GAZELLE);
        this.incompatibles.add(AnimalSpecies.ZEBRA);
    }
}
