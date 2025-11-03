package races.undead;

import races.Factory;
import races.RaceType;
import races.Troop;

import java.util.ArrayList;
import java.util.List;

public class UndeadFactory implements Factory {
    private static boolean leaderCreated = false;
    private static final double LEADER_COST = 140.0;
    private static final double BASE_COST = 70.0;
    
    @Override
    public Troop[] createTroops(RaceType race, double cashAmount) {
        if (race != RaceType.UNDEAD || cashAmount < LEADER_COST) {
            return new Troop[0];
        }
        
        List<Troop> troops = new ArrayList<>();
        double remainingCash = cashAmount;
        
        if (!leaderCreated && remainingCash >= LEADER_COST) {
            troops.add(new Lich());
            leaderCreated = true;
            remainingCash -= LEADER_COST;
        }
        
        while (remainingCash >= BASE_COST) {
            troops.add(new Undead());
            remainingCash -= BASE_COST;
        }
        
        return troops.toArray(new Troop[0]);
    }
}

