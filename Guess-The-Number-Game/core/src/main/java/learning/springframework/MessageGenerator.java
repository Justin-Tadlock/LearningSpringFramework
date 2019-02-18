package learning.springframework;

public interface MessageGenerator {

    void init();

    String getMainMessage();
    String getResultMessage();
}
