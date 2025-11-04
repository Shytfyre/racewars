package races;

import races.human.HumanFactory;
import races.nightelf.NightelfFactory;
import races.orc.OrcFactory;
import races.undead.UndeadFactory;

/**
 * Factory zur Erstellung von Truppen basierend auf Rassentyp und Geldbetrag.
 */
public class TroopFactory {

    private static final OrcFactory orcFactory = new OrcFactory();
    private static final UndeadFactory undeadFactory = new UndeadFactory();
    private static final HumanFactory humanFactory = new HumanFactory();
    private static final NightelfFactory nightelfFactory = new NightelfFactory();
    
    /**
     * Erstellt Truppen der angegebenen Rasse und Geldbetrag.
     * 
     * @param race Der Rassentyp
     * @param cashAmount Geldbetrag
     * @return Ein Array an erstellten Truppen, oder ein leeres Array
     */
    public static Troop[] createTroops(RaceType race, double cashAmount) {
        Factory factory = getFactory(race);
        if (factory == null) {
            return new Troop[0];
        }
        return factory.createTroops(race, cashAmount);
    }
    
    /**
     * Delegiert an die entsprechende Rassenfactory.
     * 
     * @param race Rassentyp
     * @return Die entsprechende Factory, oder null, falls nicht verfügbar
     */
    private static Factory getFactory(RaceType race) {
        switch (race) {
            case ORC:
                return orcFactory;
            case UNDEAD:
                return undeadFactory;
            case HUMAN:
                return humanFactory;
            case NIGHTELF:
                return nightelfFactory;
            default:
                return null;
        }
    }
}

