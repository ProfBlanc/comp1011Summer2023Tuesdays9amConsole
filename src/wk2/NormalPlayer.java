package wk2;


import java.util.Scanner;

public class NormalPlayer extends Player{

    public NormalPlayer(){
    }

    public NormalPlayer(String name, double attack, double health) {
        super(name, attack, health);
    }

    private boolean hasUsedSuperPower;

    @Override
    public void useSuperPower() {
        //either increase attack by 1
        // or increase health by 3

        Scanner input = new Scanner(System.in);

        if(!hasUsedSuperPower){
            hasUsedSuperPower = true;

            System.out.println("What do you can to do? Increase attack by 1 or increase health by 3?" +
                    "Type 'A' for attack or 'H' for health");
            String result = input.nextLine();
            if(result.toLowerCase().charAt(0) == 'h'){
                //setHealth(getHealth() + 3);
                decreaseHealth(-3);
            }
            else if(result.toLowerCase().charAt(0) == 'a'){
               // setAttack(getAttack() + 1);
                increaseAttack(1);
            }
        }
    }
}
