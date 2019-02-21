package learning.springframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == Public methods ==
    @PostConstruct
    @Override
    public void init() {
        log.info("Game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Welcome to Number Guess! \nThe number is between [" + game.getSmallest() + "," + game.getBiggest() + "]. Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return "You won! The number was " + game.getNumber();
        }
        else if(game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        }
        else if(!game.isValidNumberRange()) {
            return "Invalid number range";
        }
        else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        }
        else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
