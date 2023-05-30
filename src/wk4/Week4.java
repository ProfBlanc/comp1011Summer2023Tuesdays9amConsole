package wk4;
import com.google.gson.*;



public class Week4 {

    public static void main(String[] args) {

        example1();
    }
    static void example1(){

        /*
        JSON: javascript object notation
         */

        Gson gson;
        GsonBuilder builder = new GsonBuilder();

        //what format to expect
        //string format {  key: value, }
        String normalPlayerJson = "{\"name\": \"Batman\", \"attack\": 5, \"health\":20}";

        gson = builder.create();
        NormalPlayer player = gson.fromJson(normalPlayerJson, NormalPlayer.class);
        System.out.println(player);

        String toJsonText = gson.toJson(player);

        System.out.println(toJsonText);

        NormalPlayer player1 = gson.fromJson(toJsonText, NormalPlayer.class);
        System.out.println(player1);


    }
}
