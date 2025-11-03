package races;

public interface Factory {
    Troop[] createTroops(RaceType race, double cashAmount);
}

