public class Board {
    int[][] board;
    Board(int[][] board){
        this.board = board;
    }

    public void drawBoard(){
        int n = board.length-1;
        int m = board.length;
        System.out.println();
        for(int x = 1; x <= n+1; x++){
            if(x == 1){
                System.out.print("      " + x + " ");
            }
            else if(x == n+1){
                System.out.println(" " + x);
            }
            else if(x > 9){
                System.out.print(" " + x + " ");
            }
            else {
                System.out.print("  " + x + " ");
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    if(j == 0){
                        if(i > 8){
                            System.out.print(i + 1 + "    .   ");
                        }
                        else {
                            System.out.print(i + 1 + "     .   ");
                        }
                    }
                    if(j == n-1){
                        System.out.println(".");
                    }
                    else {
                        System.out.print(".   ");
                    }
                }

                if(board[i][j] == 1){
                    if(j == 0){
                        if(i > 8){
                            System.out.print(i + 1 + "    O   ");
                        }
                        else {
                            System.out.print(i + 1 + "     O   ");
                        }
                    }
                    else if(j == n-1){
                        System.out.println("O");
                    }
                    else {
                        System.out.print("O   ");
                    }
                }

                if(board[i][j] == 2){
                    if(j == 0){
                        if(i > 8){
                            System.out.print(i + 1 + "    X   ");
                        }
                        else {
                            System.out.print(i + 1 + "     X   ");
                        }
                    }
                    else if(j == n-1){
                        System.out.println("X");
                    }
                    else {
                        System.out.print("X   ");
                    }
                }

            }
        }
    }
}
