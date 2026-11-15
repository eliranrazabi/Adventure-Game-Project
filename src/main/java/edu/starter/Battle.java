
package edu.starter;

import java.util.Scanner;

public class Battle {

    public static boolean newEncounter(Combatant player, Combatant enemy, Scanner scanner) {

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\n" + player.getName() + " HP: " + player.getHp());
            System.out.println(player.getName() + " Resource: " + player.getResource());
            System.out.println("Attack Damage: " + player.getAttackDamage());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp());

            System.out.println("\nChoose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Special");
            System.out.println("4. Recover");

            int choice = ConsoleChoice.read(scanner, 1, 4);

            boolean validAction = true;

            switch (choice) {
                case 1:
                    System.out.println("You attacked!");
                    player.attack(enemy);
                    break;

                case 2:
                    System.out.println("You are defending!");
                    player.defend();
                    break;

                case 3:
                    System.out.println("You used special attack!");
                    validAction = player.special(enemy);
                    break;

                case 4:
                    player.recover();
                    System.out.println("You recovered 3 resource!");
                    break;
            }

            if (!validAction) {
                continue;
            }

            if (!enemy.isAlive()) {
                break;
            }

            System.out.println(enemy.getName() + " attacks!");
            enemy.attack(player);
        }

        return player.isAlive() && !enemy.isAlive();
    }
}
