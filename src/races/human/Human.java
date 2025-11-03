package races.human;

import races.Troop;

class Human extends Troop {
    private static final double HEALTH = 140.0;
    private static final double ARMOR = 40.0;
    private static final double DAMAGE = 40.0;
    private static final int SPEED = 2;
    private static final double COST = 110.0;
    
    Human() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

