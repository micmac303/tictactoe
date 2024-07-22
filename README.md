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

### TTT-02-TDD-For-Winners
The next step is to implement the function to determine the winner.
I added the ```junit-jupiter-params``` dependency to the pom.xml file to allow parameterized tests.
As a result of writing the tests and implementing the behaviour required to support them, I decided that the approach was going beyond the *'simplest thing possible that solves the problem'* E.g. the methods ```placePlayer(...)``` and ```player(...)``` are not specified as the requirements only state that a board is to be passed to the function, not that the board has any functionality itself.
These will be removed in the next merge request. Adhering to YAGNI and KISS principles. I will still merge this branch as it serves as a record of iterative development.


## Technologies
The application is implemented in Java, using Maven as the build tool.

I have opted to use JUnit 5 for testing and AssertJ for assertions.

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


