package races.undead;

import races.Element;
import races.Leader;

class Lich extends Leader {
    private static final double BASE_HEALTH = 120.0;
    private static final double ARMOR = 30.0;
    private static final double BASE_DAMAGE = 16.0;
    private static final int SPEED = 2;
    private static final double COST = 140.0;
    private static final Element ELEMENT = Element.WATER;
    private static final double BONUS = 2.3;
    
    Lich() {
        super(BASE_HEALTH, ARMOR, BASE_DAMAGE, SPEED, COST, ELEMENT, BONUS);
    }
}

