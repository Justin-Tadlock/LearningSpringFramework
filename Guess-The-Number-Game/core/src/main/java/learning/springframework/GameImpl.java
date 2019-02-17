package learning.springframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game {
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // Fields
    private NumberGenerator numberGenerator;

    private int guessCount = 10;
    private int number,
                guess,
                smallest,
                biggest,
                remainingGuesses;
    private boolean validNumberRange = true;

    // == Init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        remainingGuesses = guessCount;
        validNumberRange = true;
        log.debug("The number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy");
    }

    // == Public Methods ==
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNumberRange) {
            if(guess > number) {
                biggest = guess -1;
            }
            if(guess < number) {
                smallest = guess +1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == Private Methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
