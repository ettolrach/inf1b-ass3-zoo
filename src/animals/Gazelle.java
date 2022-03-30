package animals;

import areas.AreaType;

public class Gazelle extends Animal {
    public Gazelle() {
        this.areaType = AreaType.ENCLOSURE;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
