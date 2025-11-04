package races.nightelf;

import races.Factory;
import races.RaceType;
import races.Troop;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory zur Erstellung der Nachtelfentruppen.
 */
public class NightelfFactory implements Factory {

    private static boolean leaderCreated = false;
    private static final double LEADER_COST = 290.0;
    private static final double BASE_COST = 145.0;

    /**
     * Erstellt die Nachtelfentruppen basierend auf dem Betrag des Investments.
     * Erstellt zuerst den Daemonslayer, falls noch keiner existiert und genug Geld verfügbar ist.
     *
     *
     * @param race Der Rassentyp (muss Nachtelf sein, sonst wird ein leeres Array ausgegeben).
     * @param cashAmount die verfügbare Menge an Geld.
     * @return Ein Array der erstellten Truppen, oder leeres Array bei ungenügendem Geld oder falscher Rasse.
     */
    @Override
    public Troop[] createTroops(RaceType race, double cashAmount) {
        if (race != RaceType.NIGHTELF || cashAmount < LEADER_COST) {
            return new Troop[0];
        }
        
        List<Troop> troops = new ArrayList<>();
        double remainingCash = cashAmount;
        
        if (!leaderCreated && remainingCash >= LEADER_COST) {
            troops.add(new Daemonslayer());
            leaderCreated = true;
            remainingCash -= LEADER_COST;
        }
        
        while (remainingCash >= BASE_COST) {
            troops.add(new Nightelf());
            remainingCash -= BASE_COST;
        }
        
        return troops.toArray(new Troop[0]);
    }
}

