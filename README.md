# Tic-Tac-Toe Winning Player Determination
The Exercise

Given the rules of the game tic-tac-toe
1. Define a data model for the board and write a function that given an instance of a board
   either returns the winner or an indication that no one has won. For example, the
   signature of the function may look like:
   (board) -> player?
   Use whatever types make most sense to you in terms of inputs and outputs to the
   function.
## Initial problem analysis
A data model is to be defined for the board.

A function should be implemented that takes an instance of a board and returns the winner or an indication that no one has won.

## Initial implementation
### TTT-01-Test-Data-Model-Definition
The first step is to write a test for the function.

I have started with ```shouldIndicateNoPlayerHasWonIfBoardIsEmpty```

This is the simplest test case, however to make it pass the data model for the board must be defined. 

I have chosen to implement classes ```TicTacToe``` and ```Board``` and an enum ```Player``` for the data model.

The ```TicTacToe``` holds the function as a static method. The method signature is as follows:
```java
public static Optional<Player> winningPlayer(Board board);
```

The ```Board``` class contains a two-dimensional array of ```Optional<Player>``` objects to represent the board.

```Player``` is an enum with two values: X, and O.

The method returns an Optional<Player> object, which is empty if no player has won, or contains the winning player.

I have opted to use JUnit 5 for testing and AssertJ for assertions.

The application is implemented in Java, using Maven as the build tool.
## Build the Project
```bash
mvn clean install
```
## Run the Tests
```bash
mvn test
```
## Prerequisites
- Java 21
- Maven 3.6.0 or higher


