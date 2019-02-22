package learning.springframework.config;

import learning.springframework.annotations.GuessCount;
import learning.springframework.annotations.MaxNumber;
import learning.springframework.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "learning.springframework")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.minNumber:0}") // defaulting to 0 if the game.properties cannot be loaded
    private int minNumber;

    @Value("${game.maxNumber:50}") // defaulting to 50 if game.properties cannot be loaded
    private int maxNumber;

    @Value("${game.guessCount:10}") // defaulting to 10 if game.properties cannot be loaded
    private int guessCount;

    // == bean methods ==
    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
