import java.util.Scanner;
public class Game {

    public Board bruteForceSolver(Board myBoard){
        //Initialize the queue and the Winning Board to compare against
        Board winningBoard = new Board();
        winningBoard.makeBoard(0);
        LinkedListQueue<Board> myQueue = new LinkedListQueue<>();
        int max = 10000000;  //maximum size of queue allowed
        myQueue.enqueue(myBoard);

        //runs until we have found a solution to our board using breadth first search
        while (true) {

            //make a board to test each move
            Board a = myQueue.dequeue();
            Board b = new Board(a);
            Board c = new Board(a);
            Board d = new Board(a);

            if(a.makeMove('U', a.getLastMove()) != ' ') {
                a.setMoves('U');
                a.setLastMove('U');

                if (a.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    return a;
                }
                myQueue.enqueue(a);

            }

            if(b.makeMove('D', b.getLastMove()) != ' ') {
                b.setMoves('D');
                b.setLastMove('D');

                if (b.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    return b;
                }
                myQueue.enqueue(b);
            }

            if(c.makeMove('R', c.getLastMove()) != ' ') {
                c.setMoves('R');
                c.setLastMove('R');

                if (c.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
                    return c;
                }
                myQueue.enqueue(c);
            }

            if(d.makeMove('L', d.getLastMove()) != ' '){
                d.setMoves('L');
                d.setLastMove('L');

                if (d.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myQueue.getBoardsRemoved());
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


    //Method that solves a given board using A*
    public Board aStarSolver(Board myBoard){
        //Initialize the queue and the Winning Board to compare against
        Board winningBoard = new Board();
        winningBoard.makeBoard(0);
        AVLTree<Board> myPriorityQueue = new AVLTree<>();
        int max = 10000000;  //maximum size of queue allowed
        myPriorityQueue.insert(myBoard);

        //runs until we have found a solution to our board using best first search
        while (true) {

            Board a = myPriorityQueue.findMin();
            Board b = new Board(a);
            Board c = new Board(a);
            Board d = new Board(a);
            myPriorityQueue.deleteMin();
            if (a.equals(winningBoard)) return a;

            if(a.makeMove('U', a.getLastMove()) != ' ') {
                a.setMoves('U');
                a.setLastMove('U');
                a.findPlacesAway();

                if (a.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
                    return a;
                }
                myPriorityQueue.insert(a);

            }

            if(b.makeMove('D', b.getLastMove()) != ' ') {
                b.setMoves('D');
                b.setLastMove('D');
                b.findPlacesAway();

                if (b.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
                    return b;
                }
                myPriorityQueue.insert(b);
            }

            if(c.makeMove('R', c.getLastMove()) != ' ') {
                c.setMoves('R');
                c.setLastMove('R');
                c.findPlacesAway();

                if (c.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
                    return c;
                }
                myPriorityQueue.insert(c);
            }

            if(d.makeMove('L', d.getLastMove()) != ' '){
                d.setMoves('L');
                d.setLastMove('L');
                d.findPlacesAway();

                if (d.equals(winningBoard)) {
                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
                    return d;
                }
                myPriorityQueue.insert(d);
            }

                if(myPriorityQueue.getSize() > max){
            //If queue gets too large, the puzzle is unsolvable
                    System.out.println("Unsolvable Puzzle");
                    return null;
                }
        }
    }

    //print out the step by step instructions to solve the board
    public void showMe(Board b) {

        Board original = new Board(b);
        Board original2 = new Board(b);

        //show brute force way
        System.out.println("---Brute Force---");
        String moves = bruteForceSolver(original).getMoves();
        System.out.println("Original Board - Moves " + moves);
        System.out.println(original.toString());


        for (int i = 0; i < moves.length(); i++) {
            original.makeMove(moves.charAt(i), ' ');
            System.out.println(moves.charAt(i) + "==>");
            System.out.println(original);
        }

        //show A* way
        System.out.println("---A*---");
        String moves2 = aStarSolver(original2).getMoves();
        System.out.println("Original Board - Moves " + moves2);
        System.out.println(original2.toString());


        for (int i = 0; i < moves2.length(); i++) {
            original2.makeMove(moves2.charAt(i), ' ');
            System.out.println(moves2.charAt(i) + "==>");
            System.out.println(original2);
        }

    }


    public static void main(String[] args) {
        Board myBoard = new Board();
        Board myBoard2 = new Board();
        Game myGame = new Game();
        int []game = { 7, 6, 4, 0, 8, 1, 2, 3, 5 }; //put values 0-8 here to make any kind of board

        myBoard.makeBoard(game); //makes a board out of game one
        myBoard2.makeBoard(12); //makes a random board

        myGame.showMe(myBoard); //solve either of the boards with this method

    }
}