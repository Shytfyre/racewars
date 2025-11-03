package game;

import races.RaceType;
import races.Troop;
import races.TroopFactory;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final String name;
    private final List<Troop> troops;
    private static final double MAX_CASH = 2000.0;
    
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
    
    public String getName() {
        return name;
    }
    
    public List<Troop> getTroops() {
        return new ArrayList<>(troops);
    }
    
    public List<Troop> getAliveTroops() {
        List<Troop> alive = new ArrayList<>();
        for (Troop troop : troops) {
            if (troop.isAlive()) {
                alive.add(troop);
            }
        }
        return alive;
    }
    
    public void removeDeadTroops() {
        troops.removeIf(troop -> !troop.isAlive());
    }
    
    public boolean isDefeated() {
        return getAliveTroops().isEmpty();
    }
    
    public int getSquadSize() {
        return troops.size();
    }
}

