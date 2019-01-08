import java.util.Scanner;
public class Game {

    public void playGiven( String label, Board b){
        System.out.println(label + "\n"+  b);

    }
    public void playRandom( String label, int jumbleCount){
        Board b = new Board();
        b.makeBoard(jumbleCount);
        System.out.println(label + "\n" + b);

    }


    public static void main(String[] args) {
        Game g = new Game();
        Scanner in = new Scanner(System.in);

        int [] game0 = { 1, 2, 3, 7, 4, 0, 6, 5, 8 };
        Board b = new Board();
        b.makeBoard(game0);
        g.playGiven("game 0", b);
        System.out.println("Click any key to continue\n");
        String resp;
        resp= in.nextLine();

        int []game1 = { 1, 3, 2, 4, 5, 6, 8, 7, 0 };
        b.makeBoard(game1);
        g.playGiven("game 1", b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game2 = { 1, 3, 8, 6, 2, 0, 5, 4, 7 };
        b.makeBoard(game2);
        g.playGiven("game 2", b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game3 = { 4, 0, 1, 3, 5, 2, 6, 8, 7 };
        b.makeBoard(game3);
        g.playGiven("game 3", b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game4 = { 7, 6, 4, 0, 8, 1, 2, 3, 5 };  // Warning slow to solve
        b.makeBoard(game4);
        g.playGiven("game 4", b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game5 = { 1, 2, 3, 4, 5, 6, 8, 7, 0 };   // Warning unsolvable
        b.makeBoard(game5);
        g.playGiven("game 5", b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        boolean playAgain = true;

        int JUMBLECT = 4;  // how much jumbling to to in random board
        while (playAgain)
        {
            g.playRandom("Random Board", JUMBLECT);

            System.out.println("Play Again?  Answer Y for yes\n");
            resp= in.nextLine().toUpperCase();
            playAgain = (resp.charAt(0) == 'Y');
        }


    }


}
