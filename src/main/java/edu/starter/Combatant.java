
package edu.starter;

public class Combatant {

    private String name;
    private int HP;
    private int max_HP;
    private int resource;
    private int pending_defense;
    private int attackDamage;

    public Combatant(String name, int HP, int resource) {
        this.name = name;
        this.HP = HP;
        this.max_HP = HP;
        this.resource = resource;
        this.pending_defense = 0;
        this.attackDamage = 10;
    }

    public void takeDamage(int damage) {
        damage = Math.max(0, damage);

        int took_damage = Math.max(0, damage - pending_defense);
        pending_defense = Math.max(0, pending_defense - damage);

        HP = Checks.within(HP - took_damage, 0, max_HP);
    }

    public void recover() {
        recover(3);
    }

    public void recover(int resources) {
        resource = Checks.within(resource + resources, 0, 10);
    }

    public void defend() {
        defend(5);
    }

    public void defend(int defense) {
        pending_defense += Math.max(0, defense);
    }

    public boolean special(Combatant target) {
        if (resource < 3) {
            System.out.println("Insufficient resources!");
            return false;
        }

        resource -= 3;
        target.takeDamage(15);
        return true;
    }

    public void attack(Combatant target) {
        target.takeDamage(attackDamage);
    }

    public void restoreHp(int amount) {
        HP = Checks.within(HP + Math.max(0, amount), 0, max_HP);
    }

    public void upgradeAttack() {
        attackDamage += 2;
    }

    public void clearDefense() {
        pending_defense = 0;
    }

    public int getHp() {
        return HP;
    }

    public int getResource() {
        return resource;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return HP > 0;
    }
}
