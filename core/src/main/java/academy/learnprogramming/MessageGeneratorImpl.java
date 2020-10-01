package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == Fields ==
    private final Game game;

    // == init ==
    @PostConstruct
    public void checkGame() {
        log.info(String.valueOf(game));
    }

    // == constructors ==
    //@Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + " : can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon())
            return "You guessed it!..Number : " + game.getNumber();
        else if(game.isGameLost())
            return "You lost..Number : " + game.getNumber();
        else if(!game.isValidNumberRange())
            return "Invalid Number Range!";
        else if(game.getRemainingGuesses() == game.getGuessCount())
            return "What is your first guess?";
        else{
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
