package com.example.montyhall;

public class GameResult {
    private boolean won;
    private boolean switched;

    public GameResult(boolean won, boolean switched) {
        this.won = won;
        this.switched = switched;
    }

    public boolean isWon() {
        return won;
    }

    public boolean isSwitched() {
        return switched;
    }
}
