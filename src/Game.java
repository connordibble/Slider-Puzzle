import java.util.Scanner;
public class Game {

    //Method that solves a given board
    public Board gameSolver(Board myBoard){
        //Initialize the queue and the Winning Board to compare against
        Board winningBoard = new Board();
        winningBoard.makeBoard(0);
        LinkedListQueue<Board> myQueue = new LinkedListQueue<>();
        int max = 10000000;  //maximum size of queue allowed
        myQueue.enqueue(myBoard);

        //runs until we have found a solution to our board using breadth first search
        while (true) {

            Board a = myQueue.dequeue();
            Board b = new Board(a);
            Board c = new Board(a);
            Board d = new Board(a);

            if(a.makeMove('U', a.getLastMove()) != ' ') {
                a.setMoves('U');
                a.setLastMove('U');

                if (a.equals(winningBoard)) {
                    System.out.println("Size: " + myQueue.getSize());
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    System.out.println("Boards Added: " + myQueue.getAdded() + "\n");
                    return a;
                }
                myQueue.enqueue(a);

            }

            if(b.makeMove('D', b.getLastMove()) != ' ') {
                b.setMoves('D');
                b.setLastMove('D');

                if (b.equals(winningBoard)) {
                    System.out.println("Size: " + myQueue.getSize());
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    System.out.println("Boards Added: " + myQueue.getAdded() + "\n");
                    return b;
                }
                myQueue.enqueue(b);
            }

            if(c.makeMove('R', c.getLastMove()) != ' ') {
                c.setMoves('R');
                c.setLastMove('R');

                if (c.equals(winningBoard)) {
                    System.out.println("Size: " + myQueue.getSize());
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    System.out.println("Boards Added: " + myQueue.getAdded() + "\n");
                    return c;
                }
                myQueue.enqueue(c);
            }

            if(d.makeMove('L', d.getLastMove()) != ' '){
                d.setMoves('L');
                d.setLastMove('L');

                if (d.equals(winningBoard)) {
                    System.out.println("Size: " + myQueue.getSize());
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    System.out.println("Boards Added: " + myQueue.getAdded() + "\n");
                    return d;
                }
                myQueue.enqueue(d);
            }

                if(myQueue.getSize() > max){
                    //If queue gets too large, the puzzle is unsolvable
                    System.out.println("Unsolvable Puzzle");
                    return null;
                }
        }
    }

    //print out the step by step instructions to solve the board
    public void showMe(Board b) {

        Board original = new Board(b);
        String moves = gameSolver(b).getMoves();
        System.out.println("Original Board - Moves " + moves);
        System.out.println(original.toString());


        for (int i = 0; i < moves.length(); i++) {
            original.makeMove(moves.charAt(i), ' ');
            System.out.println(moves.charAt(i) + "==>");
            System.out.println(original);
        }

    }


    public static void main(String[] args) {
        Board myBoard = new Board();
        Game myGame = new Game();
        int []game1 = { 1, 2, 3, 7, 4, 0, 6, 5, 8 }; //put values 0-8 here to make any kind of board
        myBoard.makeBoard(game1);

        myGame.showMe(myBoard);
    }
}
