package com.davisallen;

import java.util.Scanner;

public class Game {
    private boolean isGameOver;
    private Integer numPlayers;
    private Player player1;
    private Player player2;

    public Game() {
        init();
    }

    private void init() {
        this.numPlayers = null;
        this.isGameOver = false;
    }

    private void setUp() {
        init();
        while (numPlayers == null) {
            System.out.print("Please enter number of players (1 for 1 player vs NPC, 2 for 2 players): ");
            String numPlayersString = fetchInput();
            if (numPlayersString.equals("1") || numPlayersString.equals("2")) {
                this.numPlayers = Integer.parseInt(numPlayersString);
            } else {
                System.out.println("You've got to enter either 1 or 2!");
            }
        }
        this.player1 = new HumanPlayer(this);
        switch (this.numPlayers) {
            case 1:
                this.player2 = new NPC(this);
                break;
            case 2:
                this.player2 = new HumanPlayer(this);
                break;
            default:
        }
        player1.captureAndSetName("Player 1");
        player2.captureAndSetName("Player 2");
    }

    private String incrementWinner(Player player) {
        player.setNumWins(player.getNumWins() + 1);
        return player.getName() + " wins!";
    }

    private boolean evaluateRound() {
        String p1Move = player1.getCurrentMove();
        String p2Move = player2.getCurrentMove();
        System.out.println("\n" + player1.getName() + " played " + p1Move + " and " + player2.getName() + " played " + p2Move);
        int winner = determineWinner(p1Move, p2Move);
        switch (winner) {
            case -1:
                System.out.println("Should never be here");
                return false;
            case 0:
                System.out.println("It was a tie, let's go again!");
                return false;
            case 1:
                System.out.println(incrementWinner(player1));
                return true;
            case 2:
                System.out.println(incrementWinner(player2));
                return true;
            default:
                return false;
        }
    }

    private void round() {
        player1.turn();
        player2.turn();
        boolean resolved = evaluateRound();
        if (!resolved) round();
    }

    public void play() {
        setUp();
        while (!this.isGameOver) {
            System.out.println(this.player1.getName() + " has won " + this.player1.getNumWins() + " times");
            System.out.println(this.player2.getName() + " has won " + this.player2.getNumWins() + " times");
            System.out.println("\n\n\nNew Round:");
            round();
        }
    }


    // Static stuff
    // could extract to a different file
    private static Scanner sc = new Scanner(System.in); // Do I need to do exception handling here?
    public static final String[] MOVES = {"rock", "scissors", "paper"}; // Note: order matters for determineWinner()

    public static String fetchInput() {
        String input = sc.nextLine(); // Do I need to do exception handling here?
        return input;
    }

    public static boolean moveInputIsValid(String move) {
        boolean moveIsValid = false;
        for (String validMove : MOVES) {
            if (move.toLowerCase().equals(validMove)) moveIsValid = true;
        }
        if (!moveIsValid) System.out.println("Note: Invalid input! bleep bloop blorp!");
        return moveIsValid;
    }

    // Note: depends on order of String[] MOVES
    public static int determineWinner(String p1Move, String p2Move) {
        int p1Index = -1;
        int p2Index = -1;
        for (int i = 0; i < MOVES.length; i++) {
            if (p1Move.toLowerCase().equals(MOVES[i])) p1Index = i;
            if (p2Move.toLowerCase().equals(MOVES[i])) p2Index = i;
        }
        if (p1Index == -1 || p2Index == -1) {
            return -1;
        } else if (p1Index == p2Index) {
            return 0;
        } else if (((p1Index + 1) % 3) == p2Index) {
            return 1;
        } else {
            return 2;
        }
    }

}
