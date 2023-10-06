package GomokuGame;

public class Gomoku {

    private Player player1;
    private Player player2;
    private GameType gameType;
    public Board board = new GomokuGame.Board(15);
    int[][] b1 = board.getBoardInfo();
    private  GameUI gameUI;

    private ComputerOpponent com;

    public Gomoku(){
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        //this.board = new Board(15);
        this.gameUI = new GameUI(this);
        this.com = new ComputerOpponent();
    }


    public void startGame(){
        gameUI.welcomeUser();


        gameType = (GameType) gameUI.promptForGameMode();
        if(gameType == GameType.HUMAN) {


            board.createBoard();

            while (true) {
                int[] movePlayer1 = player1.move();
                if(movePlayer1 == null){
                    System.out.println("Thank You For Playing!");
                    return;
                }
                board.move(movePlayer1[0], movePlayer1[1], 1);
                gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
                if (findWinner()) {
                    System.out.println("Player 1 wins!");
                    System.out.println("Thank You For Playing!");
                    return;
                }
                if (endGame()) {
                    System.out.println("Its a draw!");
                    System.out.println("Thank You For Playing!");
                    return;
                }
                int[] movePlayer2 = player2.move();
                if(movePlayer2 == null){
                    System.out.println("Thank You For Playing!");
                    return;
                }
                board.move(movePlayer2[0], movePlayer2[1], 2);
                gameUI.placeStone(movePlayer2[0], movePlayer2[1], 2);

                if (findWinner()) {
                    System.out.println("Player 2 wins!");
                    System.out.println("Thank You For Playing!");
                    return;
                }
                if (endGame()) {
                    System.out.println("Its a draw!");
                    System.out.println("Thank You For Playing!");
                    return;

                }
            }
        }
        else{
            board.createBoard();
            while (true) {

                int[] movePlayer1 = player1.move();
                board.move(movePlayer1[0], movePlayer1[1], 1);
                gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
                if (findWinner()) {
                    System.out.println("Player 1 wins!");
                    return;
                }
                if (endGame()) {
                    System.out.println("Its a draw!");
                    return;
                }
                int[] moveComputer = com.nextMove(movePlayer1);
                board.move(moveComputer[0], moveComputer[1], 2);
                gameUI.placeStone(moveComputer[0], moveComputer[1], 2);

                if (findWinner()) {
                    System.out.println("Player 2 wins!");
                    return;
                }
                if (endGame()) {
                    System.out.println("Its a draw!");
                    return;

                }
            }
        }
    }


    public boolean findWinner() {
        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1[i].length; j++) {
                if (b1[i][j] != 0 &&
                        (checkDirection(b1, i, j, 1, 0) ||
                                checkDirection(b1, i, j, 0, 1) ||
                                checkDirection(b1, i, j, 1, 1) ||
                                checkDirection(b1, i, j, 1, -1))) {
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
    public boolean endGame(){
        for (int i = 0; i < board.board.length ; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if(board.board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public Board getBoard(){
        return this.board;
    }

}
