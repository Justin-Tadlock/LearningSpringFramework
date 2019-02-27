package learning.springframework.console;

import learning.springframework.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess the number game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // Close context
        context.close();
    }
}
