package game;

import races.Leader;
import races.Troop;

import java.util.ArrayList;
import java.util.List;

/**
 * Kontrolliert die Anzeige der aktuellen Runde, Kämpfe und des Ergebnisses.
 */
public class GameViewer {

    /**
     * Zeigt die aktuelle Runde und die Squads beider Spieler an
     * 
     * @param game der GameController
     */
    public static void printGame(GameController game) {
        int round = game.getRound();
        Squad squad1 = game.getSquad(0);
        Squad squad2 = game.getSquad(1);

        System.out.println("-------------------- ROUND " + round + "----------------------------");

        printSquad(squad1);
        printSquad(squad2);

        System.out.println();
        System.out.println("⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️Combat⚔️⚔️⚔️⚔️⚔️⚔️⚔️⚔️");
    }

    /**
     * Zeigt die Namen und Truppenliste des Squads an
     * (Leader zuerst, dann die Truppen der jeweiligen Rassen)
     * 
     * @param squad Der Squad
     */
    private static void printSquad(Squad squad) {
        System.out.println("Squad: " + squad.getName());
        System.out.println("Squadsize: " + squad.getSquadSize());

        List<Troop> troops = squad.getTroops();
        List<Troop> leaders = new ArrayList<>();
        List<Troop> baseTroops = new ArrayList<>();

        for (Troop troop : troops) {
            if (troop.isAlive()) {
                if (troop instanceof Leader) {
                    leaders.add(troop);
                } else {
                    baseTroops.add(troop);
                }
            }
        }

        for (Troop leader : leaders) {
            System.out.println(leader.toString());
        }
        for (Troop baseTroop : baseTroops) {
            System.out.println(baseTroop.toString());
        }
        System.out.println();
    }

    /**
     * Zeigt die genauen Werte der angreifenden und verteidigenden Truppe an
     * (anhand des Beispiels im Assignment)
     * 
     * @param attacker Die attackierende Truppe
     * @param attackerHealth Leben der attackierenden Truppe
     * @param defender Die verteidigende Truppe
     * @param defenderHealth Leben der verteidigenden Truppe
     * @param damage Schaden des Angriffs
     */
    public static void printAttack(Troop attacker, double attackerHealth, Troop defender, double defenderHealth, double damage) {
        String attackerStr;
        if (attacker instanceof Leader) {
            attackerStr = "👑 " + attacker.getClass().getSimpleName();
        } else {
            attackerStr = attacker.getClass().getSimpleName();
        }

        String defenderStr;
        if (defender instanceof Leader) {
            defenderStr = "👑 " + defender.getClass().getSimpleName();
        } else {
            defenderStr = defender.getClass().getSimpleName();
        }

        System.out.printf("%s [%.2f] ⚔️ %s [%.2f] -> damage: %.2f%n",
                attackerStr, attackerHealth, defenderStr, defenderHealth, damage);
    }

    /**
     * Zeigt das Ergebnis des Angriffs
     * verbliebene Leben/tot
     * 
     * @param attacker Die angreifende Truppe
     * @param defender Die verteidigende Truppe
     */
    public static void printAttackResult(Troop attacker, Troop defender) {
        String attackerStr;
        if (attacker instanceof Leader) {
            attackerStr = "👑 " + attacker.getClass().getSimpleName();
        } else {
            attackerStr = attacker.getClass().getSimpleName();
        }

        String defenderStr;
        if (defender instanceof Leader) {
            defenderStr = "👑 " + defender.getClass().getSimpleName();
        } else {
            defenderStr = defender.getClass().getSimpleName();
        }

        if (defender.isAlive()) {
            System.out.printf("  %s [%.2f], %s [%.2f]%n",
                    attackerStr, attacker.getHealth(), defenderStr, defender.getHealth());
        } else {
            System.out.printf("  %s [%.2f], %s ☠☠☠%n",
                    attackerStr, attacker.getHealth(), defenderStr);
        }
    }

    /**
     * Zeigt die "Game Over" Nachricht mit dem Namen des Gewinners
     * 
     * @param winnerName Name des Gewinners
     */
    public static void printGameOver(String winnerName) {
        System.out.println("---------------Game over--------------------");
        System.out.println("Winner: " + winnerName);
    }
}