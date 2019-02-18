package learning.springframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    // == Public methods ==
    @PostConstruct
    @Override
    public void init() {
        guessCount = 10;
        log.info("Game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Welcome Message Generator";
    }

    @Override
    public String getResultMessage() {
        return "Welcome Result Message";
    }
}
