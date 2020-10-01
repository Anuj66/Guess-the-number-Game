package academy.learnprogramming.Service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService{

    // == fields ==
    private final MessageGenerator messageGenerator;
    private final Game game;

    // == constructors ==
    @Autowired
    public GameServiceImpl(MessageGenerator messageGenerator, Game game) {
        this.messageGenerator = messageGenerator;
        this.game = game;
    }

    // == public methods ==
    @PostConstruct
    public void init() {
        log.info("Main message : {}", messageGenerator.getMainMessage());
        log.info("Number : {}", game.getNumber());
    }

    @Override
    public boolean isGameOver() {
        if(game.isGameWon() || game.isGameLost())
            return true;
        return false;
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }

}
