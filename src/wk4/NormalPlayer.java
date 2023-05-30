package wk4;

public class NormalPlayer {

    String name;
    int attack, health;

    public NormalPlayer(String name, int attack, int health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
    }

    @Override
    public String toString() {
        return "NormalPlayer{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", health=" + health +
                '}';
    }
}
