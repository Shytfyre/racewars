package races.human;

import races.Element;
import races.Leader;

class Archmage extends Leader {
    private static final double BASE_HEALTH = 140.0;
    private static final double ARMOR = 40.0;
    private static final double BASE_DAMAGE = 40.0;
    private static final int SPEED = 2;
    private static final double COST = 220.0;
    private static final Element ELEMENT = Element.FIRE;
    private static final double BONUS = 5.0;
    
    Archmage() {
        super(BASE_HEALTH, ARMOR, BASE_DAMAGE, SPEED, COST, ELEMENT, BONUS);
    }
}

