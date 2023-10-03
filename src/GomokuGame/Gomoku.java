package GomokuGame;

public class Gomoku {

   private final Player player1;
   private final Player player2;
   private GameType gameType;
   private final Board board;
   private final GameUI gameUI;

   public Gomoku(Player player1, Player player2, GameType gameType, int board){
       this.player1 = player1;
       this.player2 = player2;
       this.gameType = gameType;
       this.board = new Board(board);
       this.gameUI = new GameUI(this);
   }
   public void startGame(){
       gameUI.welcomeUser();

       if(gameType == null){
           gameType = (GameType) gameUI.promptForGameMode();
       }
       board.createBoard();
       boolean endedGame = false;
       while(true){
           int movePlayer1 = player1.move();
           board.move(0,0, movePlayer1);
           gameUI.placeStone(0, 0, movePlayer1);
           if(endedGame) break;

           int movePlayer2 = player2.move();
           board.move(0, 0, movePlayer2);
           gameUI.placeStone(0, 0, movePlayer2);
           endedGame = endGame();
       }
       gameUI.findWinner();
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

   }

}
