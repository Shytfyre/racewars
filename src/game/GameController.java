package game;

import races.Leader;
import races.RaceType;
import races.Troop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private int round;
    private int currentPlayer;
    private final Squad[] squads;
    private final Random random;
    
    public GameController() {
        this.round = 1;
        this.currentPlayer = 0;
        this.random = new Random();
        
        // Hardcoded squad creation for Player 1
        // Example: 9 Humans (1 Archmage + 8 Humans = 220 + 8*110 = 1100), 4 Orcs (1 Farseer + 3 Orcs = 300 + 3*150 = 750)
        // Total: 1850
        Investment[] player1Investments = {
            new Investment(RaceType.HUMAN, 1100.0),
            new Investment(RaceType.ORC, 750.0)
        };
        Squad squad1 = new Squad("Player1", player1Investments);
        
        // Hardcoded squad creation for Player 2 (from remaining races)
        // Example: Undead and Nightelf
        Investment[] player2Investments = {
            new Investment(RaceType.UNDEAD, 700.0),  // 1 Lich + 8 Undead = 140 + 8*70 = 700
            new Investment(RaceType.NIGHTELF, 725.0) // 1 Daemonslayer + 3 Nightelf = 290 + 3*145 = 725
        };
        Squad squad2 = new Squad("Player2", player2Investments);
        
        this.squads = new Squad[]{squad1, squad2};
    }
    
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
            
            // Sort attackers so leaders attack first
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
            
            // Each troop attacks in order
            for (Troop attacker : sortedAttackers) {
                if (aliveDefenders.isEmpty()) {
                    break;
                }
                
                // Select random target
                Troop defender = aliveDefenders.get(random.nextInt(aliveDefenders.size()));
                
                // Capture health before attack
                double attackerHealthBefore = attacker.getHealth();
                double defenderHealthBefore = defender.getHealth();
                
                // Perform attack
                double damage = attacker.attack(defender);
                
                // Display attack (with health before attack)
                GameViewer.printAttack(attacker, attackerHealthBefore, defender, defenderHealthBefore, damage);
                
                // Remove dead troops and update defender list
                defendingSquad.removeDeadTroops();
                aliveDefenders = defendingSquad.getAliveTroops();
                
                // Display result (with health after attack)
                GameViewer.printAttackResult(attacker, defender);
            }
            
            // Switch player
            currentPlayer = 1 - currentPlayer;
            
            // Increment round after both players have had a turn
            if (currentPlayer == 0) {
                round++;
            }
            
            System.out.println();
        }
        
        // Determine winner
        String winner;
        if (squads[0].isDefeated()) {
            winner = squads[1].getName();
        } else {
            winner = squads[0].getName();
        }
        
        GameViewer.printGameOver(winner);
    }
    
    private boolean isGameOver() {
        return squads[0].isDefeated() || squads[1].isDefeated();
    }
    
    public int getRound() {
        return round;
    }
    
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Squad getSquad(int index) {
        return squads[index];
    }
    
    public static void main(String[] args) {
        GameController game = new GameController();
        game.runGame();
    }
}

