package animals;

import areas.AreaType;

public class Seal extends Animal {
    public Seal() {
        this.areaType = AreaType.AQUARIUM;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
