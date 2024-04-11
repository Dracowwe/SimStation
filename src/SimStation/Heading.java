package SimStation;

import mvc.*;
import java.util.*;

public enum Heading {
    NORTH, EAST, SOUTH, WEST;

    public static Heading parse(String heading) {
        if(Objects.equals(heading, "north")) { return NORTH; }
        if(Objects.equals(heading, "east")) { return EAST; }
        if(Objects.equals(heading, "south")) { return SOUTH; }
        if(Objects.equals(heading, "west")) { return WEST; }
        return null;
    }

    public static Heading random() {
        int random = new Random().nextInt(5);
        if(random == 1) { return NORTH; }
        if(random == 2) { return EAST; }
        if(random == 3) { return SOUTH; }
        if(random == 4) { return WEST;}
        return null;
    }

}
