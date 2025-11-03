package game;

import races.RaceType;

public class Investment {
    private final RaceType raceType;
    private final double cashAmount;

    public Investment(RaceType raceType, double cashAmount) {
        this.raceType = raceType;
        this.cashAmount = cashAmount;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public double getCashAmount() {
        return cashAmount;
    }
}

