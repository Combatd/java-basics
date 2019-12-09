package com.davisallen;

public class NPC extends Player {

    public NPC(Game game) {
        super(game);
    }

    @Override
    public void captureAndSetName(String greeting) {
        this.setName("Hal");
    }

    @Override
    public void turn() {
        int numMoves = Game.MOVES.length;
        int randInt = (int)Math.floor(Math.random() * numMoves);
        this.setCurrentMove(Game.MOVES[randInt]);
    }
}
