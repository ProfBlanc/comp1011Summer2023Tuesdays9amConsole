package wk2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FightingGame implements Game{

    private Path basePath = Path.of(".", "src", "game_data", "players");
    private Scanner input = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();

    private StringBuilder sb = new StringBuilder();

    public FightingGame(){

        //start our game logic

        start();//ask user for info
        //start the fight
        fight();

    }
    @Override
    public void start() {
    System.out.println("Welcome to our fighting game. Ready, set, FIGHT!");
        System.out.print("Do you want to (S)tart a new new game " +
                "or (L)oad a game? Type 'S' or 'L': ");
        sb.append(input.nextLine());

        if(sb.toString().toLowerCase().charAt(0) == 'l'){
            //System.out.println("Not yet implemented");

            if(load("batman") && load("superman")){

                //read contents
                List<String> data1 = loadFileDataArray(basePath.resolve("batman.txt"));
                List<String> data2 = loadFileDataArray(basePath.resolve("superman.txt"));

                //instantiate file contents to Player object

                Player player1 = new NormalPlayer(data1.get(0).trim(),
                        Double.parseDouble(data1.get(1)),
                        Double.parseDouble(data1.get(2))
                                );

                Player player2 = new NormalPlayer(data2.get(0).trim(),
                        Double.parseDouble(data2.get(1)),
                                Double.parseDouble(data2.get(2))
                                );

                //add Players to array list of players
                players.add(player1);
                players.add(player2);
            }
        }
        else if(sb.toString().toLowerCase().charAt(0) == 's'){

            sb.setLength(0); // clear content

            int validPlayers = 0;
            while(validPlayers < 2){

    System.out.println("Enter Name of Player " + (validPlayers + 1) );
                try {
                    String playerName = input.nextLine();

                    System.out.println("Enter Attack of Player " + playerName);
                    double playerAttack = input.nextDouble();

                    System.out.println("Enter Health of Player " + playerName);
                    double playerHealth = input.nextDouble();
                    input.nextLine();

                    players.add(new NormalPlayer(playerName, playerAttack, playerHealth));
                    validPlayers++;
                }
                catch (InputMismatchException e){
                    System.err.println("Invalid Numerical Values Inputted");
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }


        }

    }

    private List<String> loadFileDataArray(Path filename){

        try {

            return Files.readAllLines(filename);
        }
        catch (IOException e){
            return new ArrayList<>();
        }
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

    /**
     * Determines if a specific file exists
     * @param filename
     * @return
     */
    @Override
    public boolean load(String filename) {
        return basePath.resolve(filename + ".txt").toFile().exists();
    }

    private void turn(int attacker){
        if(attacker < 0 || attacker > 1)
            return;

        int victim = attacker == 0 ? 1 : 0;
        System.out.printf("%s is attacking %s%n",
                players.get(attacker).getName(), players.get(victim).getName());
        players.get(victim).decreaseHealth(players.get(attacker).getAttack());
        System.out.printf("%s health is now %.1f%n",
                players.get(victim).getName(), players.get(victim).getHealth());

        System.out.println("*".repeat(20));


    }
    public boolean isGameOver(){

        for(Player current : players){
            if(current.getHealth() <= 0)
                return true;
        }
        return false;
    }
    public void fight(){

        int counter = -1;
        while(!isGameOver()){
            counter++;
            turn(counter % 2);
            }

        }
}
