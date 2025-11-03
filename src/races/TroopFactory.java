package races;

import races.human.HumanFactory;
import races.nightelf.NightelfFactory;
import races.orc.OrcFactory;
import races.undead.UndeadFactory;

public class TroopFactory {
    private static final OrcFactory orcFactory = new OrcFactory();
    private static final UndeadFactory undeadFactory = new UndeadFactory();
    private static final HumanFactory humanFactory = new HumanFactory();
    private static final NightelfFactory nightelfFactory = new NightelfFactory();
    
    public static Troop[] createTroops(RaceType race, double cashAmount) {
        Factory factory = getFactory(race);
        if (factory == null) {
            return new Troop[0];
        }
        return factory.createTroops(race, cashAmount);
    }
    
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

