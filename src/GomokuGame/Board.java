package GomokuGame;

public class Board{

    protected int[][] board;

    public Board(int size) {
        this.board = new int[size][size];
    }
    public void createBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[j][i] = 0;
            }
        }
    }
    public void move(int x, int y, int player){
        if(board[x][y] == 0){
            board[x][y] = player;
        }
        else{
            System.out.println("position already occupied");
        }
    }
    public int[][] getBoardInfo(){
        return this.board;
    }
}
