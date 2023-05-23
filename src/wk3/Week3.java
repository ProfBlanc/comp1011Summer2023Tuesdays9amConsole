package wk3;
import com.google.gson.*;
import wk2.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Week3 {

    static void example1(){
        Lion lion = new Lion("Simba", 4, 50);
        System.out.println(lion);

        Cat cat = new Lion("Cool Lion", 8, 75);

        System.out.println(cat);
        lion.testMethod();


        //Human is an Animal
        //Animal a = new Human();

    }

    static void example2(){


        /*
            Path: location in file system
            File: ONE specific file or folder in file system
         */

        Path path = Path.of(".", "src", "game_data", "players");

        System.out.println(path.toFile().exists());

        //list all files and directories of this PATH

        for(File currentFile : path.toFile().listFiles()){
        //System.out.println(currentFile.getName());
            try {
                String fileContents = Files.readString(Path.of(".", "src",
                        "game_data", "players", currentFile.getName()));


                System.out.println(fileContents);

                String[] lines = fileContents.split("\\n");
                for(String line : lines){
                    System.out.println(line);
                }

                Player player1 = new NormalPlayer(lines[0].trim(),
                        Double.parseDouble(lines[1]),
                        Double.parseDouble(lines[2]));

                System.out.printf("This Player's name is %s, attack is %.1f, " +
                        "health is %.1f %n", player1.getName(),
                        player1.getAttack(), player1.getHealth());

            }
            catch (IOException e){
                System.err.println("Error reading file " + currentFile.getName());
            }
        }

    }

    public static void main(String[] args) {
        example2();
    }
}
