package GomokuGame;
import java.util.Scanner;

public class Player{

    private String name;
    private static Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }
    public void play(){
        System.out.println(name + " is now playing.");
    }
    public Strategy selectStrategy(){
        return null;
    }
    public int[] move(){
        System.out.println(name + " Turn ");
        System.out.println("Enter row:");
        int row = input.nextInt()-1;

        System.out.println("Enter column:");
        int col = input.nextInt()-1;

        return new int[] {col, row};
    }

}
