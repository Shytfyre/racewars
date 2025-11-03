package races.orc;

import races.Element;
import races.Leader;

class Farseer extends Leader {
    private static final double BASE_HEALTH = 100.0;
    private static final double ARMOR = 30.0;
    private static final double BASE_DAMAGE = 33.0;
    private static final int SPEED = 1;
    private static final double COST = 300.0;
    private static final Element ELEMENT = Element.EARTH;
    private static final double BONUS = 1.2;
    
    Farseer() {
        super(BASE_HEALTH, ARMOR, BASE_DAMAGE, SPEED, COST, ELEMENT, BONUS);
    }
}

