package PD;

import mvc.*;

abstract class Strategy {
    abstract boolean cooperate();
}

class Cooperate extends Strategy {
    boolean cooperate() {
        return true;
    }
}

class RandomlyCooperate extends Strategy {
    boolean cooperate() {
        int random = Utilities.rng.nextInt(2);
        return random < 1;
    }
}

class Cheat extends Strategy {
    boolean cooperate() {
        return false;
    }
}

class Tit4Tat extends Strategy {
    boolean cooperate() {   // if prisoner partner cheated return false
        //return Prisoner.cheated;
        return false;
    }
}