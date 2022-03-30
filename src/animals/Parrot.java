package animals;

import areas.AreaType;

public class Parrot extends Animal {
    public Parrot() {
        this.areaType = AreaType.CAGE;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
