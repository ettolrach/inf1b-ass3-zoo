package animals;

import areas.AreaType;

public class Shark extends Animal {
    public Shark(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.AQUARIUM;
    }
}
