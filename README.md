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

## Final Solution

### Data Model
The final data model for the Tic-Tac-Toe board is implemented as a `List<Character>` with 9 elements. Each to represent a square on the board:

```
 0 | 1 | 2
---+---+---
 3 | 4 | 5
---+---+---
 6 | 7 | 8
```
This choice was made for several reasons:

1. Simplicity: A one-dimensional list is easier to work with than a two-dimensional array.
2. Readability: Characters 'X', 'O', and '-' (for empty) are intuitive and easy to understand.
3. Efficiency: A list of primitives is memory-efficient and quick to access.

This representation allows for easy indexing and iteration over the board state.

### Winner Function Implementation
The `winner` function (method) signature in the `TicTacToe` class is:

```java
public static char winner(List<Character> board)
```
Returns the winning player ('X' or 'O') or '-' to indicate no one has won.

### Key aspects of the implementation:

#### Win Check:

Utilizes a WIN_COMBINATIONS list to define all possible winning alignments

Uses Java streams to efficiently check for a winner

Implements a separate hasWinner method to check wins for each player

#### Early Return:

Returns '-' if there are fewer than 5 moves, as no win is possible

#### Input Validation:

Checks for correct board size (9 elements)

Ensures only valid characters (X, O, -) are present

Verifies that the difference between X and O counts is at most 1

#### Multiple Winners Check:
Throws an IllegalArgumentException if both X and O have winning combinations

### Result:

Returns 'X' or 'O' if there's a winner, or '-' if there's no winner



This implementation ensures efficient and correct determination of the game's outcome while handling various edge cases and invalid board states.

##  Implementation steps - path to final solution...
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

### TTT-03-Refactor-For-Simplicity
The next step is to refactor the code to simplify the code and remove unnecessary methods and classes.

After much consideration of how to represent players / noughts and crosses on the board, e.g. Optionals of enums, optionals of characters or just characters, I decided to go with characters X, O and a dash ('-') for an empty square for simplicity and readability.

I have also refactored the data model as a ```List``` of ```Characters``` with 9 elements to represent the board as this is much simpler to deal with than a two-dimensional array.

Parameterised tests are used to test the function with different board configurations.

I have defined the winning combinations as a list of lists of integers representing the indexes of the board that must be occupied by the same player to win.

As per *'Given the rules of the game tic-tac-toe'*, to avoid unnecessary checks for a winner I have added a validation for at least five noughts and crosses on the board,
validation for the number of noughts and crosses on the board validation for the state of multiple winners being on the board, validation for the board size being 9 and validation for the board containing only X, O and '-' characters.

The check for a winner is implemented using a stream of the winning combinations and a check for the same player occupying the indexes of the winning combination.


## Technologies
The application is implemented in Java, using Maven as the build tool.

I have opted to use JUnit 5 for unit testing.

## Run the Tests
```bash
mvn test
```
## Prerequisites
- Java 21
- Maven 3.6.0 or higher


