package races;

public abstract class Leader extends Troop {
    protected final Element element;
    protected final double bonus;
    
    protected Leader(double baseHealth, double armor, double baseDamage, int speed, double cost, Element element, double bonus) {
        super(baseHealth * bonus, armor, baseDamage * bonus, speed, cost);
        this.element = element;
        this.bonus = bonus;
    }
    
    @Override
    public double attack(Troop target) {
        double baseDamage = speed * damage;
        double damageDealt = baseDamage;
        
        if (target instanceof Leader) {
            Leader targetLeader = (Leader) target;
            damageDealt = applyElementalMultiplier(baseDamage, targetLeader.element);
        }
        
        double actualDamage = target.mitigateDamage(damageDealt);
        target.health -= actualDamage;
        return actualDamage;
    }
    
    private double applyElementalMultiplier(double damage, Element targetElement) {
        if ((element == Element.FIRE && targetElement == Element.AIR) ||
            (element == Element.WATER && targetElement == Element.FIRE) ||
            (element == Element.EARTH && targetElement == Element.WATER) ||
            (element == Element.AIR && targetElement == Element.EARTH)) {
            return damage * 2.0;
        }
        
        if ((element == Element.FIRE && targetElement == Element.WATER) ||
            (element == Element.WATER && targetElement == Element.EARTH) ||
            (element == Element.EARTH && targetElement == Element.AIR) ||
            (element == Element.AIR && targetElement == Element.FIRE)) {
            return damage * 0.5;
        }
        
        return damage;
    }
    
    public Element getElement() {
        return element;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    @Override
    public String toString() {
        return String.format("👑 %s [%.2f]", getClass().getSimpleName(), health);
    }
}

