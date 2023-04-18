import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class Main {


    static boolean isTrue = true;
    static String result;
    static int diff=0;

static class raiting{
    File file = new File("/home/METRO.LOC/u550149/Документы/rating.txt");
    static int count;

   static  String [][] matrix =new String[3][2];

    static String [][] reading_data (File file)  {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < 2; j++) {
                    matrix[i][j] = scanner.next();
                }}
        }
        return matrix;
    }


   static int score(String s){
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0].equals(s)){
                count = Integer.parseInt(matrix[i][1]);
                break;
            }else {count = 0;}
        }
    return count;
    }

    public void get_data(File file) {
    }
}
static class game{
    static String game;
    static List<String> newgame;
    game(String a){
        this.game=a.equals("")?"rock,paper,scissors":a.toLowerCase();
        this.newgame = Arrays.asList(game.split("\\s*,\\s*"));
    }

    static int get_index( List<String> newgame,String s) {
        int index=-1;
        for (int i = 0; i < newgame.size(); i++) {
            if (s.equals(newgame.get(i))){
            index= i;
            }
             }
            return index;
            }
   static  String check(String a,String b){
        List<String> s = Arrays.asList("rock,fire,scissors,snake,human,tree,wolf,sponge,paper,air,water,dragon,devil,lightning,gun".split("\\s*,\\s*"));

        int p1 =get_index(s,a);
        int p2 =get_index(s,b);
        String result="";
        if (p1<=s.size()/2){
            if (p2>p1&&p2<=p1+s.size()/2){
                result = "Well done. The computer chose " +b+ " and failed";
            }else{result="Sorry, but the computer chose "+b;}
        }else if (p1>s.size()/2){

            if (p2>=p1-s.size()/2&&p2<p1){
                result = "Well done. The computer chose " +b+ " and failed";

            }else{result="Sorry, but the computer chose "+b;}

        }
        return result;
    }


}
static class player{
    String name;
    int index;
    int score;
    String choice;
    player(String a){
        this.name = a;
        this.score =raiting.score(a);
    }
   void get_choice(String s){
        this.choice=s;
        this.index = game.get_index(game.newgame,s);
    }
   void get_index(int b){
        this.index=b;
        this.choice = game.newgame.get(b);

    }

}

   public static void main(String[] args) {
        raiting raiting = new raiting();
        raiting.reading_data(raiting.file);
        System.out.print("Enter your name: >");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

       System.out.println(raiting.score(name));
        System.out.print("Hello, "+name+"\n");
        player p1 = new player(name);
        game game=new game(sc1.nextLine());

        System.out.println("Okay, let's start");


        while(isTrue) {

            String s = sc1.nextLine();
            p1.get_choice(s);
            int num = 0;
            if (game.newgame.contains(s)) {
                Random rand = new Random();
                num = rand.nextInt(game.newgame.size());


            player p2 = new player("PC");
            p2.get_index(num);
             if (p1.index == p2.index) {
                    System.out.println("There is a draw (" + s + ")");
                    p1.score += 50;
                }else{
                 if (game.check(p1.choice,p2.choice).equals("Well done. The computer chose " +p2.choice+ "and failed")){
                     p1.score += 100;
                 }
                 System.out.println(game.check(p1.choice,p2.choice));}




            } else if (s.equals("!exit")) {
                System.out.println("Bye!");
                isTrue =false;
            }else if (s.equals("!rating")) {
                System.out.println("Your rating: "+p1.score);

            }else {
                System.out.println("Invalid input");

        }
        }
   }}

