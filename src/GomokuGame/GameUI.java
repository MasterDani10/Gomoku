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
        System.out.println("Select a game mode: ");
        System.out.println("1. Human");
        System.out.println("2. Strategy");

        int choice = input.nextInt();

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
        game.getBoard().move(x, y, movePlayer1);
        displayBoard();
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

    public void findWinner() {
    }
}
