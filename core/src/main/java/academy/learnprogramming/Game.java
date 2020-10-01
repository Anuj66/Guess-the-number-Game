package academy.learnprogramming;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

    int getRemainingGuesses();

    int getGuessCount();

}