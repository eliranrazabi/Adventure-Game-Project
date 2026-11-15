
package edu.starter;

import java.util.Scanner;

public class Game {

    private Combatant player;
    private boolean firstEncounterWon;
    private boolean rewardClaimed;

    public Game() {
        player = new Combatant("Player", 100, 5);
        firstEncounterWon = false;
        rewardClaimed = false;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== ENCOUNTER 1 =====");

        Combatant enemy1 = new Combatant("Enemy 1", 30, 0);

        boolean firstWin = Battle.newEncounter(player, enemy1, scanner);

        if (!firstWin) {
            System.out.println("\nYou lost the adventure!");
            return;
        }

        firstEncounterWon = true;

        System.out.println("\nYou defeated the first enemy!");

        if (!chooseReward(scanner)) {
            return;
        }

        player.clearDefense();

        System.out.println("\n===== ENCOUNTER 2 =====");

        Combatant enemy2 = new Combatant("Enemy 2", 45, 0);

        boolean secondWin = Battle.newEncounter(player, enemy2, scanner);

        if (secondWin) {
            System.out.println("\nCongratulations! You completed the adventure!");
        } else {
            System.out.println("\nYou lost the adventure!");
        }
    }

    private boolean chooseReward(Scanner scanner) {

        while (!rewardClaimed) {

            System.out.println("\nChoose your reward:");
            System.out.println("1. RECOVERY (+25 HP)");
            System.out.println("2. POWER (+2 Attack Damage)");

            if (!scanner.hasNextLine()) {
                return false;
            }

            int choice = ConsoleChoice.read(scanner, 1, 2);

            if (choice == -1) {
                System.out.println("Invalid reward choice. Enter 1 or 2.");
                continue;
            }

            Reward reward;

            if (choice == 1) {
                reward = Reward.RECOVERY;
            } else {
                reward = Reward.POWER;
            }

            claimReward(reward);
        }

        return true;
    }

    boolean claimReward(Reward reward) {

        if (!firstEncounterWon || rewardClaimed) {
            return false;
        }

        switch (reward) {
            case RECOVERY:
                player.restoreHp(25);
                System.out.println("\nYou restored 25 HP!");
                break;

            case POWER:
                player.upgradeAttack();
                System.out.println("\nYour attack damage is now "
                        + player.getAttackDamage() + "!");
                break;
        }

        rewardClaimed = true;
        return true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
