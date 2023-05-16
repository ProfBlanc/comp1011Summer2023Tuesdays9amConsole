package wk1;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.player1 = new Player("Batman", 5d, 20d);
        game.player2 = new Player("Superman", 6d, 21);
        /*
        game.turn(game.player1, game.player2);// one player attacks another player
        game.turn(game.player2, game.player1);// one player attacks another player
        */
        int counter = -1;
        while(!game.isGameOver()){
            counter++;

            if(counter % 2 == 0){
                game.turn(game.player1, game.player2);
            }
            else{
                game.turn(game.player2, game.player1);
            }

        }
    }
}