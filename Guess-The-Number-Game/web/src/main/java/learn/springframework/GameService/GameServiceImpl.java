package learn.springframework.GameService;

import learning.springframework.GameImpl;
import learning.springframework.MessageGeneratorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GameServiceImpl implements GameService {


    @Autowired
    private final GameImpl game;

    @Autowired
    private final MessageGeneratorImpl messageGenerator;


    public GameServiceImpl(GameImpl game, MessageGeneratorImpl messageGenerator) {
        this.game = game;

        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    void Init() {

    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public String getMainMessage() {
        return null;
    }

    @Override
    public String getResultMessage() {
        return null;
    }

    @Override
    public void checkGuess() {

    }

    @Override
    public void reset() {

    }
}
