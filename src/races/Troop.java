package races;

/**
 * Abtrakte Basis Klasse für die Truppen im Spiel.
 */
public abstract class Troop {

    protected double health;
    protected final double armor;
    protected final double damage;
    protected final int speed;
    protected final double cost;
    
    /**
     * Erstellt eine neue Truppe mit den angegebenen Werten.
     * 
     * @param health Leben
     * @param armor Rüstung
     * @param damage Schaden
     * @param speed Geschwindigkeit
     * @param cost Kosten
     */
    protected Troop(double health, double armor, double damage, int speed, double cost) {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.speed = speed;
        this.cost = cost;
    }
    
    /**
     * Attackiert das Ziel und zieht seinen Schaden von ihren Leben ab.
     * 
     * @param target Ziel des Angriffs
     * @return angerichteter Schaden
     */
    public double attack(Troop target) {
        double damageDealt = speed * damage;
        double actualDamage = target.mitigateDamage(damageDealt);
        target.health -= actualDamage;
        return actualDamage;
    }
    
    /**
     * Gibt den Status der Truppe zurück.
     * 
     * @return true, wenn die Truppe lebt (Leben über 0), oder false, wenn nicht
     */
    public boolean isAlive() {
        return health > 0;
    }
    
    /**
     * Errechnet den totalen Schaden nach Abzug der Rüstung
     * 
     * @param incomingDamage Schaden des Angreifers
     * @return Der tatsächlich verursachte Schaden
     */
    public double mitigateDamage(double incomingDamage) {
        double reduction = armor / 100.0;
        return incomingDamage * (1.0 - reduction);
    }
    
    /**
     * Gibt das aktuelle Leben der Truppe zurück.
     * 
     * @return das aktuelle Leben
     */
    public double getHealth() {
        return health;
    }
    
    /**
     * Gibt die Rüstung der Truppe zurück.
     * 
     * @return Rüstungswert
     */
    public double getArmor() {
        return armor;
    }
    
    /**
     * Gibt den Schaden der Truppe zurück.
     * 
     * @return Schaden
     */
    public double getDamage() {
        return damage;
    }
    
    /**
     * Gibt die Geschwindigkeit der Truppe zurück.
     * 
     * @return Geschwindigkeit
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * Gibt die Kosten der Truppe zurück.
     * 
     * @return Kosten
     */
    public double getCost() {
        return cost;
    }
    
    /**
     * Gibt die Truppe zusammen mit ihrem Leben zurück.
     * 
     * @return Ein String mit dem Namen und den Leben der Truppe
     */
    @Override
    public String toString() {
        return String.format("%s [%.2f]", getClass().getSimpleName(), health);
    }
}

