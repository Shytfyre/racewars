package races.ghost;

import races.Troop;

class Ghost extends Troop {
    private static final double HEALTH = 100.0;
    private static final double ARMOR = 0.0;
    private static final double DAMAGE = 0.0;
    private static final int SPEED = 0;
    private static final double COST = 0.0;
    
    Ghost() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

