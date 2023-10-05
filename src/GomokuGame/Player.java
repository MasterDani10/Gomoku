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
        System.out.println(name + " Enter row: ");
        int row = input.nextInt();

        System.out.println(" Enter column: ");
        int col = input.nextInt();

        return new int[] {row, col};
    }

}
