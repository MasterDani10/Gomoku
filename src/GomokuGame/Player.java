package GomokuGame;


public class Player{

    protected String name;

    public Player(String name){
        this.name = name;
    }
    public void play(){

    }
    public Strategy selectStrategy(){
        return null;
    }
    public int move(){
        return 0;
    }

}
