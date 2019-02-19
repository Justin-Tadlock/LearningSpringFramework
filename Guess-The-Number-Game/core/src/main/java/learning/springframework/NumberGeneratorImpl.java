package learning.springframework;

import learning.springframework.annotations.MaxNumber;
import learning.springframework.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    @Autowired
    @MinNumber
    private int minNumber;

    @Autowired
    @MaxNumber
    private int maxNumber;


    @Override
    public int next() {
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
