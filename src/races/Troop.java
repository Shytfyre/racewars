package races;

public abstract class Troop {
    protected double health;
    protected final double armor;
    protected final double damage;
    protected final int speed;
    protected final double cost;
    
    protected Troop(double health, double armor, double damage, int speed, double cost) {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.speed = speed;
        this.cost = cost;
    }
    
    public double attack(Troop target) {
        double damageDealt = speed * damage;
        double actualDamage = target.mitigateDamage(damageDealt);
        target.health -= actualDamage;
        return actualDamage;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public double mitigateDamage(double incomingDamage) {
        double reduction = armor / 100.0;
        return incomingDamage * (1.0 - reduction);
    }
    
    public double getHealth() {
        return health;
    }
    
    public double getArmor() {
        return armor;
    }
    
    public double getDamage() {
        return damage;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public double getCost() {
        return cost;
    }
    
    @Override
    public String toString() {
        return String.format("%s [%.2f]", getClass().getSimpleName(), health);
    }
}

