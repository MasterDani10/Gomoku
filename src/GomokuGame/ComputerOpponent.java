package GomokuGame;

import java.awt.*;

public class ComputerOpponent {
    int[] nextMove;
    public int[] nextMove(int[] movePlayer){
        nextMove = movePlayer;
        nextMove[0] = nextMove[0]+1;
        return nextMove;
    }
    public int[] nextMove2(int[] movePlayer){
        nextMove = movePlayer;
        nextMove[0] = nextMove[0]-1;
        return nextMove;
    }
}
