import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] board = new int[15][15];
        Board b = new Board(board);
        b.drawBoard();
        int x, y;

        System.out.println("Enter the x-coordinate:");
        x = input.nextInt();
        System.out.println("Enter the y-coordinate:");
        y = input.nextInt();
        board[x][y] = 1;
    }
}
