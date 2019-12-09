package com.davisallen;

public class HumanPlayer extends Player {

    public HumanPlayer(Game game) {
        super(game);
    }

    @Override
    public void captureAndSetName(String greeting) {
        String name = "";
        while (name.equals("")) {
            System.out.print(greeting + ", please enter your name: ");
            name = Game.fetchInput();
        }
        this.setName(name);
        System.out.println("Hi, " + name);
    }

    @Override
    public void turn() {
        String move = "";
        do {
            System.out.print(this.getName() + ", please enter your move (rock, paper or scissors): ");
            move = Game.fetchInput();
        } while(!Game.moveInputIsValid(move));
        this.setCurrentMove(move);
    }
}
