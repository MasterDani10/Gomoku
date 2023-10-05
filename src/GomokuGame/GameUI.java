package GomokuGame;
import java.util.Scanner;
public class GameUI{

    private final Gomoku game;
    private final Scanner input;

    public GameUI(Gomoku game){
        this.game = game;
        this.input = new Scanner(System.in);
    }
    public void welcomeUser(){
        System.out.println("Welcome to Gomoku");
    }
    public Object promptForGameMode(){
        boolean repeat = true;
        int choice;
        System.out.println("Select a game mode: ");
        System.out.println("(1) Human");
        System.out.println("(2) Strategy");
        choice = input.nextInt();
        if(choice == 1 || choice == 2){
            repeat = false;
        }

        while(repeat) {
            System.out.println("Sorry, please enter 1 or 2 to Select a game mode: ");
            System.out.println("(1) Human");
            System.out.println("(2) Strategy");
            choice = input.nextInt();
            if(choice == 1 || choice == 2){
                repeat = false;
            }


        }

        switch(choice){
            case 1:
                return GameType.Human();
            case 2:
                return GameType.Strategy();
            default:
                System.out.println("Invalid choice, going to Human mode");
                return GameType.Human();
        }
    }

    public void placeStone(int x, int y, int movePlayer1) {
        game.getBoard().createBoard();
    }

    private void displayBoard() {
        int[][] board = game.getBoard().getBoardInfo();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean findWinner() {
        int[][] board = game.getBoard().getBoardInfo();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 &&
                        (checkDirection(board, i, j, 1, 0) ||
                                checkDirection(board, i, j, 0, 1) ||
                                checkDirection(board, i, j, 1, 1) ||
                                checkDirection(board, i, j, 1, -1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int[][] board, int x, int y, int dx, int dy) {
        int n = board.length;
        int player = board[x][y];

        for (int i = 0; i < 5; i++){
            int newX = x + dx * i;
            int newY = y + dy * i;
            if (newX < 0 || newX >= n || newY < 0 || newY >= n || board[newX][newY] != player) {
                return false;
            }
        }
        return true;
    }
}
