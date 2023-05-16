package wk1;

public class Game {

    public Player player1, player2;

    public void turn(Player attacking, Player gettingAttacked){

        //one player attacks another player
        System.out.printf("%s is attacking %s.%n",
                attacking.getName(), gettingAttacked.getName());


        //do the attack
        gettingAttacked.setHealth( gettingAttacked.getHealth() - attacking.getAttack()   );
        System.out.printf("%s health is %.1f%n",
                gettingAttacked.getName(),
                gettingAttacked.getHealth());

        System.out.println("*".repeat(20));

    }

    public boolean isGameOver(){
        return player1.getHealth() <= 0 || player2.getHealth() <= 0;
    }
}
