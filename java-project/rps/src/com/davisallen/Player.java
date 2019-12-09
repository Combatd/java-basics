package com.davisallen;

public abstract class Player {
    private String name;
    private String currentMove;
    private int numWins;
    private Game game;

    public Player(Game game) {
        setCurrentMove(null);
        setNumWins(0);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public String getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(String currentMove) {
        this.currentMove = currentMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void captureAndSetName(String greeting);
    public abstract void turn();
}
