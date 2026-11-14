package edu.starter;
import java.util.Scanner;
import java.sql.SQLOutput;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
 static int player_HP = 100;
 static int enemy_HP = 100;
 static int resource = 5;
 static boolean defending = false;
 static void attack() {
  enemy_HP = Checks.within(enemy_HP-10, 0, 100);
  System.out.println("Fighter attacked with lightsaber! Enemy's HP: " + enemy_HP);
 }
 static void counterattack() {
  player_HP = Checks.within(player_HP-10,0, 100);
  System.out.println("Enemy striked back! Player's HP: " + player_HP);
 }
 static void defend() {
  defending = true;
  System.out.println("You are now defending!");
 }
 static void special() {
  resource = resource - 3;
  enemy_HP = Checks.within(enemy_HP-15, 0, 100);
  System.out.println("You used special attack! Enemy's HP: " + enemy_HP + " Resources: " + resource);
 }
 static void recover() {
  resource = resource + 3;
  System.out.println("You recovered! Resources: " + resource);
 }

 public static void main(String[] args){
  int round = 0;
  Scanner in = new Scanner(System.in);
  while(true){
   int choice = ConsoleChoice.read(in, 1, 4);
   if(choice == -1) {
    System.out.println("Invalid Input!");
    continue;
   } else if(choice == 1){
    attack();
   } else if (choice == 2) {
    defend();
   } else if (choice == 3) {
    if(resource<3){
     System.out.println("Insufficient resources!");
    } else {
     special();
    }
   }
   else if (choice == 4) {
    recover();
   }
   counterattack();

  }

 }
}

