package races.human;

import races.Factory;
import races.RaceType;
import races.Troop;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory zur Erstellung der Menschentruppen.
 */
public class HumanFactory implements Factory {

    private static boolean leaderCreated = false;
    private static final double LEADER_COST = 220.0;
    private static final double BASE_COST = 110.0;
    
    /**
     * Erstellt die Menschentruppen basierend auf dem Betrag des Investments.
     * Erstellt zuerst den Archmage, falls noch keiner existiert und genug Geld verfügbar ist.
     *
     * 
     * @param race Der Rassentyp (muss Mensch sein, sonst wird ein leeres Array ausgegeben).
     * @param cashAmount die verfügbare Menge an Geld.
     * @return Ein Array der erstellten Truppen, oder leeres Array bei ungenügendem Geld oder falscher Rasse.
     */
    @Override
    public Troop[] createTroops(RaceType race, double cashAmount) {
        if (race != RaceType.HUMAN || cashAmount < LEADER_COST) {
            return new Troop[0];
        }
        
        List<Troop> troops = new ArrayList<>();
        double remainingCash = cashAmount;
        
        if (!leaderCreated && remainingCash >= LEADER_COST) {
            troops.add(new Archmage());
            leaderCreated = true;
            remainingCash -= LEADER_COST;
        }
        
        while (remainingCash >= BASE_COST) {
            troops.add(new Human());
            remainingCash -= BASE_COST;
        }
        
        return troops.toArray(new Troop[0]);
    }
}

