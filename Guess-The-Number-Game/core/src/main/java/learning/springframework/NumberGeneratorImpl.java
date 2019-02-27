package learning.springframework;

import learning.springframework.annotations.MaxNumber;
import learning.springframework.annotations.MinNumber;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    @Getter
    private final int minNumber;

    @Getter
    private final int maxNumber;

    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    @Override
    public int next() {
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }
}
