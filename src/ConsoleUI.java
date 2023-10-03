import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] board = new int[15][15];
        Board b = new Board(board);
        b.drawBoard();
        int x, y;
        boolean win = false;
        boolean player1 = true;
        boolean repeat = false;
        while(!win) {
            if(player1){
                System.out.println("Player 1 Turn");
            }
            if(!player1){
                System.out.println("Player 2 Turn");
            }

            System.out.println("Enter the x-coordinate:");
            x = input.nextInt();
            System.out.println("Enter the y-coordinate:");
            y = input.nextInt();
            if(board[y - 1][x - 2] == 1 || board[y - 1][x - 2] == 2){
                repeat = true;
            }
            while(repeat == true){
                System.out.println("Sorry, invalid coordinates!");
                System.out.println("Enter the x-coordinate:");
                x = input.nextInt();
                System.out.println("Enter the y-coordinate:");
                y = input.nextInt();
                if(board[y - 1][x - 2] == 0){
                    repeat = false;
                }
            }

            if(player1){
                board[y - 1][x - 2] = 1;
            }
            if(!player1){
                board[y - 1][x - 2] = 2;
            }

            b.drawBoard();
            player1 = !player1;

        }
    }
}
