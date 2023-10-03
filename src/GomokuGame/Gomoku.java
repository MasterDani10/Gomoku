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
        Gomoku game = new Gomoku();
        game.startGame();
   }

}
