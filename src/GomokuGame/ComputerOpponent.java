package GomokuGame;

import java.util.Random;

public class ComputerOpponent extends Player{
    private int[][] board;
    private Random ran;

    public ComputerOpponent(int[][] board){
        super("computer");
        this.board = board;
        this.ran = new Random();
    }

    @Override
    public int[] move() {
        int row = ran.nextInt(board.length);
        int col = ran.nextInt(board.length);

        return new int[] {row, col};
    }
}
