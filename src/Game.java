import java.util.Scanner;
public class Game {

    //Method that solves a given board
    public Board gameSolver(Board myBoard){
        //Initialize the queue and the Winning Board to compare against
        Board winningBoard = new Board();
        winningBoard.makeBoard(0);
        AVLTree<Board> myPriorityQueue = new AVLTree<>();
        int max = 10000000;  //maximum size of queue allowed
        myPriorityQueue.insert(myBoard);

        //runs until we have found a solution to our board using best first search
        //TDL figure out how to assign priorities and we should be good to go
        //make a method to figure out priority in the constructor of Board
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
                a.incrementMovesSoFar();
                a.findPlacesAway();

                if (a.equals(winningBoard)) {
//                    System.out.println("Size: " + myPriorityQueue.getSize());
//                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
//                    System.out.println("Boards Added: " + myPriorityQueue.getAdded() + "\n");
                    return a;
                }
                myPriorityQueue.insert(a);

            }

            if(b.makeMove('D', b.getLastMove()) != ' ') {
                b.setMoves('D');
                b.setLastMove('D');
                b.incrementMovesSoFar();
                b.findPlacesAway();

                if (b.equals(winningBoard)) {
//                    System.out.println("Size: " + myPriorityQueue.getSize());
//                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
//                    System.out.println("Boards Added: " + myPriorityQueue.getAdded() + "\n");
                    return b;
                }
                myPriorityQueue.insert(b);
            }

            if(c.makeMove('R', c.getLastMove()) != ' ') {
                c.setMoves('R');
                c.setLastMove('R');
                c.incrementMovesSoFar();
                c.findPlacesAway();

                if (c.equals(winningBoard)) {
//                    System.out.println("Size: " + myPriorityQueue.getSize());
//                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
//                    System.out.println("Boards Added: " + myPriorityQueue.getAdded() + "\n");
                    return c;
                }
                myPriorityQueue.insert(c);
            }

            if(d.makeMove('L', d.getLastMove()) != ' '){
                d.setMoves('L');
                d.setLastMove('L');
                d.incrementMovesSoFar();
                d.findPlacesAway();

                if (d.equals(winningBoard)) {
//                    System.out.println("Size: " + myPriorityQueue.getSize());
//                    System.out.println("Boards Removed: " + myPriorityQueue.getBoardsRemoved());
//                    System.out.println("Boards Added: " + myPriorityQueue.getAdded() + "\n");
                    return d;
                }
                myPriorityQueue.insert(d);
            }

//                if(myPriorityQueue.getSize() > max){
                    //If queue gets too large, the puzzle is unsolvable
//                    System.out.println("Unsolvable Puzzle");
//                    return null;
//                }
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
        Board myBoard2 = new Board();
        Game myGame = new Game();
        int []game1 = { 7, 6, 4, 0, 8, 1, 2, 3, 5  }; //put values 0-8 here to make any kind of board

        myBoard.makeBoard(game1); //makes a board out of game one
        myBoard2.makeBoard(15); //makes a random board

        myGame.showMe(myBoard2); //solve either of the boards with this method

    }
}
