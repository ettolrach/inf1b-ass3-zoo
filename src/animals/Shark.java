package animals;

import areas.AreaType;

public class Shark extends Animal {
    public Shark() {
        this.areaType = AreaType.AQUARIUM;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
