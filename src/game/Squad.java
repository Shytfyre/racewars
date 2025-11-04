package game;

import races.Troop;
import races.TroopFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiegelt den Squad (die Truppen) eines Spielers wider
 * und organisiert Truppenerstellung
 */
public class Squad {

    private final String name;
    private final List<Troop> troops;
    private static final double MAX_CASH = 2000.0;
    
    /**
     * Erstellt einen neuen Squad mit dem übergebenen Namen und Investments
     * 
     * @param name Der Name des Squads
     * @param investments Die Investments aus denen der Squad erstellt wird
     * @throws IllegalArgumentException falls die Summe der Investments den maximalen
     * Geldbetrag überschreitet oder das Investment nicht für die Klasse ausreicht
     */
    public Squad(String name, Investment... investments) {
        this.name = name;
        this.troops = new ArrayList<>();
        
        double totalCash = 0.0;
        for (Investment investment : investments) {
            totalCash += investment.getCashAmount();
        }
        
        if (totalCash > MAX_CASH) {
            throw new IllegalArgumentException("Total investment exceeds maximum cash of $" + MAX_CASH);
        }
        
        for (Investment investment : investments) {
            Troop[] createdTroops = TroopFactory.createTroops(investment.getRaceType(), investment.getCashAmount());
            if (createdTroops.length == 0) {
                throw new IllegalArgumentException("Insufficient cash for race: " + investment.getRaceType());
            }
            for (Troop troop : createdTroops) {
                troops.add(troop);
            }
        }
    }
    
    /**
     * Gibt den Namen des Squads zurück.
     * 
     * @return Der Name des Squads.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gibt eine Liste der gesamten Truppen zurück.
     * 
     * @return Eine Liste der Truppen
     */
    public List<Troop> getTroops() {
        return new ArrayList<>(troops);
    }
    
    /**
     * Gibt eine Liste aller lebendigen Truppen zurück.
     * 
     * @return Eine Lister der lebendigen Truppen.
     */
    public List<Troop> getAliveTroops() {
        List<Troop> alive = new ArrayList<>();
        for (Troop troop : troops) {
            if (troop.isAlive()) {
                alive.add(troop);
            }
        }
        return alive;
    }
    
    /**
     * Entfernt alle toten Truppen aus der Liste.
     */
    public void removeDeadTroops() {
        troops.removeIf(troop -> !troop.isAlive());
    }
    
    /**
     * Überprüft, ob der Squad besiegt wurde.
     * 
     * @return true, wenn keine lebendigen Truppen in der Liste sind
     * und false, wenn noch lebendige Truppen in der Liste sind.
     */
    public boolean isDefeated() {
        return getAliveTroops().isEmpty();
    }
    
    /**
     * Gibt die gesamte Anzahl der Truppen des Squads zurück.
     * 
     * @return Anzahl der Truppen im Squad.
     */
    public int getSquadSize() {
        return troops.size();
    }
}

