package wk1;

public class Player {

    private String name;
    private double attack, health;

    public Player(){}
    public Player(String name, double attack, double health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
    }

    //alt+insert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
