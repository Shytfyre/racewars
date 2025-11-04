package game;
import races.Leader;
import races.RaceType;
import races.Troop;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Kontrolliert den Spielablauf, erstellt die Squads und steuert die Kampfrunden
 */
public class GameController {

    private int round;
    private int currentPlayer;
    private final Squad[] squads;
    private final Random random;
    
    /**
     * Erstellt einen neuen GameController mit zwei (aktuell) vorgegebenen Squads
     */
    public GameController() {
        this.round = 1;
        this.currentPlayer = 0;
        this.random = new Random();
        
        // Beispiel für Spieler 1; 9 x Mensch, 5 x Orc; Kosten: 2000

        Investment[] player1Investments = {
            new Investment(RaceType.HUMAN, 1100.0),
            new Investment(RaceType.ORC, 900.0)
        };
        Squad squad1 = new Squad("Player1", player1Investments);
        
        // Beispiel für Spieler 2; 11 x Untote, 7 x Nachtelfen; Kosten: 2000

        Investment[] player2Investments = {
            new Investment(RaceType.UNDEAD, 840.0),
            new Investment(RaceType.NIGHTELF, 1160.0)
        };
        Squad squad2 = new Squad("Player2", player2Investments);
        
        this.squads = new Squad[]{squad1, squad2};
    }
    
    /**
     * Ablauf der Gameloop, steuert die Runden beider Spieler
     * und attackiert bis ein Team vernichtet ist
     */
    public void runGame() {
        while (!isGameOver()) {
            GameViewer.printGame(this);
            
            Squad attackingSquad = squads[currentPlayer];
            Squad defendingSquad = squads[1 - currentPlayer];
            
            List<Troop> aliveAttackers = attackingSquad.getAliveTroops();
            List<Troop> aliveDefenders = defendingSquad.getAliveTroops();
            
            if (aliveAttackers.isEmpty() || aliveDefenders.isEmpty()) {
                break;
            }
            
            // Sortierte Angreiferliste (Leader zuerst, dann base troops)
            List<Troop> sortedAttackers = new ArrayList<>();
            List<Troop> baseTroops = new ArrayList<>();
            for (Troop attacker : aliveAttackers) {
                if (attacker instanceof Leader) {
                    sortedAttackers.add(attacker);
                } else {
                    baseTroops.add(attacker);
                }
            }
            sortedAttackers.addAll(baseTroops);

            for (Troop attacker : sortedAttackers) {
                if (aliveDefenders.isEmpty()) {
                    break;
                }
                
                // Zufällige Wahl des Ziels aus der Liste der lebendigen Gegner
                Troop defender = aliveDefenders.get(random.nextInt(aliveDefenders.size()));

                double attackerHealthBefore = attacker.getHealth();
                double defenderHealthBefore = defender.getHealth();

                double damage = attacker.attack(defender);

                GameViewer.printAttack(attacker, attackerHealthBefore, defender, defenderHealthBefore, damage);

                defendingSquad.removeDeadTroops();
                aliveDefenders = defendingSquad.getAliveTroops();

                GameViewer.printAttackResult(attacker, defender);
            }
            
            // Wechsel von Spieler 1 zu Spieler 2
            currentPlayer = 1 - currentPlayer;
            
            // Erhöht den Counter wieder, wenn Spieler 2 fertig ist damit Spieler 1 weiter machen kann
            if (currentPlayer == 0) {
                round++;
            }
            
            System.out.println();
        }
        
        // Erkennung + Ausgabe des Siegers
        String winner;
        if (squads[0].isDefeated()) {
            winner = squads[1].getName();
        } else {
            winner = squads[0].getName();
        }
        
        GameViewer.printGameOver(winner);
    }
    
    /**
     * Überprüft, ob das Spiel zu Ende ist
     *
     * @return true, wenn einer der Squads vernichtet ist, ansonsten false
     */
    private boolean isGameOver() {
        return squads[0].isDefeated() || squads[1].isDefeated();
    }
    
    /**
     * Abfrage der aktuellen Rundenzahl
     * 
     * @return Rundenzahl
     */
    public int getRound() {
        return round;
    }
    
    /**
     * Abfrage des Squads am übergebenen Index
     * 
     * @param index Der Index des Squads im "squads" Array
     * @return Der Squad am übergebenen Index
     */
    public Squad getSquad(int index) {
        return squads[index];
    }
    
    /**
     * Main Methode des Programms, hier wird das Spiel gestartet
     * 
     * @param args Kommandozeileneingaben
     */
    public static void main(String[] args) {
        GameController game = new GameController();
        game.runGame();
    }
}

