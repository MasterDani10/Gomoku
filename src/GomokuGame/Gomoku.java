package GomokuGame;

public class Gomoku {

   private Player player1;
   private Player player2;
   private GameType gameType;
   private Board board;
   private  GameUI gameUI;

   public Gomoku(){
       this.player1 = new Player("Player 1");
       this.player2 = new Player("Player 2");
       this.gameType = GameType.Human();
       this.board = new Board(15);
       this.gameUI = new GameUI(this);
   }


    public void startGame(){
       gameUI.welcomeUser();

       if(gameType != null){
           gameType = (GameType) gameUI.promptForGameMode();
       }
       board.createBoard();

       while(true) {
           int[] movePlayer1 = player1.move();
           board.move(movePlayer1[0], movePlayer1[1], 1);
           gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
           if (gameUI.findWinner()) {
               System.out.println("Player 1 wins!");
               return;
           }
           if (endGame()) {
               System.out.println("Its a draw!");
               return;
           }
           int[] movePlayer2 = player2.move();
           board.move(movePlayer2[0], movePlayer2[1], 2);
           gameUI.placeStone(movePlayer2[0], movePlayer2[1], 2);

           if (gameUI.findWinner()) {
               System.out.println("Player 2 wins!");
               return;
           }
           if (endGame()) {
               System.out.println("Its a draw!");
               return;

           }
       }
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

   public static void main(String[] args){
        Gomoku game = new Gomoku();
        game.startGame();
   }

}
