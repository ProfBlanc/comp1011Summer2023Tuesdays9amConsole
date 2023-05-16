package wk2;

import java.util.Scanner;

public class FightingGame implements Game{


    Scanner input = new Scanner(System.in);
    @Override
    public void start() {
    System.out.println("Welcome to our fighting game. Ready, set, FIGHT!");
    }

    @Override
    public void stop(){
        System.out.println("Type 'S' to stop the fight");
        String result = input.nextLine();
        if(result.toLowerCase().charAt(0) == 's'){
            pause();
        }
    }
    @Override
    public void pause() {
        System.out.println("Fight has been paused");
        System.out.println("Type 'R' to resume fight");

        String result = input.nextLine();
        if(result.toLowerCase().charAt(0) == 'r'){
                resume();
        }

    }
    @Override
    public void resume() {
        System.out.println("Fight has been resumed!");
    }

    @Override
    public void end() {
        System.out.println("Good fight, lads!");
    }

    @Override
    public String rules() {
        return null;
    }

    @Override
    public boolean save(String filename) {
        return false;
    }

    @Override
    public boolean load(String filename) {
        return false;
    }
}
