package GomokuGame;

public enum GameType {
    HUMAN,
    STRATEGY;

    public static GameType Human() {
        return HUMAN;
    }

    public static GameType Strategy() {
        return STRATEGY;
    }
}
