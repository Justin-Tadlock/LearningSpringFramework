package learning.springframework.service;

import learning.springframework.GameImpl;
import learning.springframework.MessageGeneratorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    private final GameImpl game;

    private final MessageGeneratorImpl messageGenerator;

    @Autowired
    public GameServiceImpl(GameImpl game, MessageGeneratorImpl messageGenerator) {
        this.game = game;

        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    private void init()
    {
        log.info("Initialized GameServiceImpl");
        reset();
    }

    @Override
    public boolean isGameOver() {
        return (game.isGameWon() || game.isGameLost());
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
