import java.util.Random;

public class Board implements Comparable<Board> {

    private static final int SIZE = 3;
    private int[][] board;  // Values of board
    private int blankRow;   // Row location of blank
    private int blankCol;   // Column location of blank
    private String moves = "";
    private char lastMove = ' ';
    private int placesAway;

    public Board() {
        board = new int[SIZE][SIZE];
    }

    //Copy constructor
    Board(Board b) {

        board = new int[SIZE][];
        for (int i = 0; i < SIZE; i++)
            this.board[i] = b.board[i].clone();
        this.blankRow = b.blankRow;
        this.blankCol = b.blankCol;
        moves = b.moves;
        lastMove = b.lastMove;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(board[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    ;


    // return true if board is identical to b
    boolean equals(Board b) {

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] != b.board[i][j]) return false;
        return true;

    }

    //Create a board by performing legal moves on a board
//jumbleCt indicates the number of moves to make
//if jumbleCt ==0, return the winning board
    void makeBoard(int jumbleCt) {
        int val = 1;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = val++;
        blankRow = SIZE - 1;
        blankCol = SIZE - 1;
        board[blankRow][blankCol] = 0;
        jumble(jumbleCt);
    }

    //Create a board from a given set of values
    void makeBoard(int[] values) {
        int c = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (values[c] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
                board[i][j] = values[c++];
            }
    }


    boolean slideUp()  // If possible, slides a tile up into the blank position.  Returns success of operation.
    {
        if (blankRow == SIZE - 1) return false;
        board[blankRow][blankCol] = board[blankRow + 1][blankCol];
        board[blankRow + 1][blankCol] = 0;
        blankRow += 1;
        return true;
    }

    boolean slideDown()  // If possible, slides a tile down into the blank position.  Returns success of operation.
    {
        if (blankRow == 0) return false;
        board[blankRow][blankCol] = board[blankRow - 1][blankCol];
        board[blankRow - 1][blankCol] = 0;
        blankRow -= 1;
        return true;
    }

    boolean slideLeft()  // If possible, slides a tile left into the blank position.  Returns success of operation.
    {
        if (blankCol == SIZE - 1) return false;
        board[blankRow][blankCol] = board[blankRow][blankCol + 1];
        board[blankRow][blankCol + 1] = 0;
        blankCol += 1;
        return true;
    }

    boolean slideRight()  // If possible, slides a tile right into the blank position.  Returns success of operation.
    {
        if (blankCol == 0) return false;
        board[blankRow][blankCol] = board[blankRow][blankCol - 1];
        board[blankRow][blankCol - 1] = 0;
        blankCol -= 1;
        return true;
    }


    // Randomly apply ct moves to the board, making sure they are legal and don't undo the previous move
    void jumble(int ct) {
        Random rand = new Random();
        String moveStr = "UDLR";  // Moves representing Up, Down, Left, Right
        char lastMove = ' ';
        char thisMove = ' ';
        for (int i = 0; i < ct; i++) {
            thisMove = ' ';
            while (thisMove == ' ') {
                thisMove = moveStr.charAt(rand.nextInt(4));
                thisMove = makeMove(thisMove, lastMove);
            }
            lastMove = thisMove;
        }
    }

    // Make the move indicated by m (L Left, R Right, U Up, D Down) if it is legal and if it doesn't undo the move specified by lastmove
// Return a blank if the move could not be made, otherwise return the move
    char makeMove(char m, char lastmove) {

        boolean moved = false;
        switch (m) {
            case 'R':
                if (lastmove != 'L') {
                    moved = slideRight();
                }
                break;
            case 'L':
                if (lastmove != 'R') {
                    moved = slideLeft();
                }
                break;
            case 'D':
                if (lastmove != 'U') {
                    moved = slideDown();
                }
                break;
            case 'U':
                if (lastmove != 'D') {
                    moved = slideUp();
                }
                break;
        }
        if (!moved)
            return ' ';
        return m;
    }

    //method to find the number of places different from the winning board using hamming distance
    public void findPlacesAway(){
        this.placesAway = 0;
        Board winningBoard = new Board();
        winningBoard.makeBoard(0);
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] != winningBoard.board[i][j]) this.placesAway += 1;
            }
        }
    }


    //do your board comparisons here
    @Override
    public int compareTo(Board b2){
        return (getPriority().compareTo( b2.getPriority()));
    }

    public String getMoves(){return this.moves;}
    public void setMoves(char a){this.moves = this.moves + a;}
    public char getLastMove(){return lastMove;}
    public void setLastMove(char a){this.lastMove = a;}
    public Integer getPriority(){return this.moves.length() + this.placesAway;}


}

