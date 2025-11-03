package races.orc;

import races.Factory;
import races.RaceType;
import races.Troop;

import java.util.ArrayList;
import java.util.List;

public class OrcFactory implements Factory {
    private static boolean leaderCreated = false;
    private static final double LEADER_COST = 300.0;
    private static final double BASE_COST = 150.0;
    
    @Override
    public Troop[] createTroops(RaceType race, double cashAmount) {
        if (race != RaceType.ORC || cashAmount < LEADER_COST) {
            return new Troop[0];
        }
        
        List<Troop> troops = new ArrayList<>();
        double remainingCash = cashAmount;
        
        if (!leaderCreated && remainingCash >= LEADER_COST) {
            troops.add(new Farseer());
            leaderCreated = true;
            remainingCash -= LEADER_COST;
        }
        
        while (remainingCash >= BASE_COST) {
            troops.add(new Orc());
            remainingCash -= BASE_COST;
        }
        
        return troops.toArray(new Troop[0]);
    }
}

