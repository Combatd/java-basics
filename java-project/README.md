# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Rock, Paper, Scissors in Java

## Overview

It's time to put your Java knowledge to use. Create a basic version of rock–paper–scissors that allows users to play against the computer in the console. The game consists of a few main features:

- Play rock–paper–scissors against a computer player.
- Play rock–paper–scissors against a human player.

> **Hint**: Use a [random number generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html) to make the computer's choice.

---

## Feature Requirements

Your game must:

- Have a main menu with options to enter `2 players` or `vs. computer`.
- If the user enters `2 players`, they should be able to play rock–paper–scissors against a human competitor.
- If the user enters `vs. computer`, they should be able to play against the computer.
- When the game is over, the winner should be declared.

## Technical Requirements

- Use classes to remove repetitive parts of code, and create an abstract `Player` class to manage the state of the player (if they won or lost, how many points they have, what move they made).
- Handle invalid user input.
- Handle incorrect capitalization of otherwise valid user input ("rock," "Rock," "RoCk," "ROCK," and more).
- Each class (including a `Player` class) should have methods associated with it and be instantiated as an object (as opposed to a singleton or an interface).
- Use `public`, `private`, and `static` variables, methods, and members within each class appropriately. 
- Incorporate exception handling to make sure your game crashes gracefully if it receives bad input.
- Get standard input with Java using a `Scanner`, or use `Processing` to get mouse, keyboard, or other input.
- Use arrays or array lists to store game history (if applicable).

## Bonus Ideas

- Write automated JUnit tests for your application.
- Use an Agile project management framework for your game.
- If the user enters `history`, the program should display previous game history (winner's name, game date, and more).
- Use Java packages to modularize code. Place any helper tools in these packages — they could be related input, networking, or graphics.
- Use Maven to install external dependencies your game might require.
- Use [generics](https://docs.oracle.com/javase/tutorial/extra/generics/index.html) on collections such as arrays and array lists to store different data composed of different types.
- Use multithreading to handle concurrent requests (like in multiplayer games).
- Incorporate video, text, data, networking, and sound into your game via `Processing`.

### Necessary Deliverables

Submit a pull request with a Java program that meets the above requirements.

Below, you can see sample output:

```
Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

rock
Computer picks: scissors
User picks: rock
You win!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

paper
Computer picks: scissors
User picks: paper
You lose!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

history
=== GAME HISTORY ===
WIN: Player picked rock, computer picked scissors
LOSS: Player picked paper, computer picked scissors

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

quit
```

---

#### Suggested Ways to Get Started

- Don't hesitate to write throwaway code to solve short-term problems.
- Read the docs for whatever technologies you use. **Most of the time, you can follow a tutorial. However, learning to read documentation is crucial to your success as a developer.**
- Write pseudocode before you write actual code.

---

### Useful Resources

- [Random Number Generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
- [Rules and History of Rock–Paper–Scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors)

---

#### Project Feedback and Evaluation


Based on the requirements, you can earn a maximum of eight points on this project. Your instructors will score each of your technical requirements using the scale below:

Score | Expectations
----- | ------------
**0** | Incomplete.
**1** | Does not meet expectations.
**2** | Meets expectations. Good job!
**3** | Exceeds expectations. You wonderful creature, you!

This will serve as a helpful overall gauge of whether or not you meet the project goals, but **the more important scores are the individual ones** above, which can help you identify where to focus your efforts for the next project.
