package learn.springframework.GameService;

public interface GameService {
    boolean isGameOver();
    String getMainMessage();
    String getResultMessage();
    void checkGuess();
    void reset();
}
