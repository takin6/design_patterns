package Bridge;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDisplay(int times) {
        Random random = new Random();
        int randomTimes = random.nextInt(times);
        multiDisplay(randomTimes);
    }

}
