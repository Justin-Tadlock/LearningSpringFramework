package learning.springframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // Get Number Generator bean
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // Get a random number
        int number = numberGenerator.next();
        log.info("Number = {}", number);

        // Get Game bean
        Game game = context.getBean(Game.class);

        // Close context
        context.close();
    }
}
