package Strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(3);
        return Hand.getHand(bet);
    }

    @Override
    public void study(boolean win) {}
}
