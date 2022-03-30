package animals;

import areas.AreaType;

public class Lion extends Animal {
    public Lion() {
        this.areaType = AreaType.ENCLOSURE;
    }

    public boolean isCompatibleWith(Animal a) {
        return a.getHabitat() == this.areaType;
    }
}
