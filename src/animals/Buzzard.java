package animals;

import areas.AreaType;

public class Buzzard extends Animal {
    public Buzzard() {
        this.areaType = AreaType.CAGE;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
