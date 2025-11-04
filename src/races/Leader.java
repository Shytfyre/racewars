package races;

/**
 * Spiegelt die Anführer wider.
 */
public abstract class Leader extends Troop {

    protected final Element element;
    protected final double bonus;
    
    /**
     * Erstellt einen neuen Anführer mit den angegebenen Werten.
     * Health and damage are multiplied by the bonus value.
     * 
     * @param baseHealth Basistruppen Leben
     * @param armor Rüstungswert
     * @param baseDamage Basistruppen Schaden
     * @param speed Geschwindigkeitswert
     * @param cost Kosten
     * @param element Element
     * @param bonus Bonus Multiplikator
     */
    protected Leader(double baseHealth, double armor, double baseDamage, int speed, double cost, Element element, double bonus) {
        super(baseHealth * bonus, armor, baseDamage * bonus, speed, cost);
        this.element = element;
        this.bonus = bonus;
    }
    
    /**
     * Attackiert mit Rücksicht auf elementare Stärken/Schwächen.
     * 
     * @param target Das Ziel des Angriffs.
     * @return der verursachte Schaden.
     */
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
    
    /**
     * Errechnung des Schadens gemäß der elementaren Beziehung zueinander.
     * Ich habe zusätzlich zu der Stärke auch eine Schwäche (x0.5) eingebaut.
     *
     * @param damage Schaden vor Element-rechnung
     * @param targetElement Das Element des Ziels
     * @return der totale Schaden
     */
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
    
    /**
     * Gibt das Element des Anführers zurück.
     * 
     * @return Element des Anführers
     */
    public Element getElement() {
        return element;
    }
    
    /**
     * Gibt den Bonus des Anführers zurück.
     * 
     * @return Bonus Multiplikator
     */
    public double getBonus() {
        return bonus;
    }
    
    /**
     * Fügt einen Kronen-Emoji zu dem Namen des Anführers hinzu.
     * 
     * @return Name und aktuelles Leben des Anführers mit dem neuen Emoji als String.
     */
    @Override
    public String toString() {
        return String.format("👑 %s [%.2f]", getClass().getSimpleName(), health);
    }
}

