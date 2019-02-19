package learning.springframework.console;

import learning.springframework.config.AppConfig;
import learning.springframework.MessageGenerator;
import learning.springframework.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Number Generator bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // Get a random number
        int number = numberGenerator.next();
        log.info("Number = {}", number);

        // Get Game bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());

        // Close context
        context.close();
    }
}
