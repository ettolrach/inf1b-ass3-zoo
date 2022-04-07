package animals;

import areas.AreaType;

public class Lion extends Animal {
    public Lion(String nickname) {
        this.nick = nickname;
        this.areaType = AreaType.ENCLOSURE;
    }
}
