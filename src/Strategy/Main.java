package Strategy;

// Summary
// strategy: アルゴリズム（戦略・作戦・方策）をカチッと切り替え、同じ問題を別の方法で解くのを容易にするパターン

// Actor
// Strategy: 戦略を利用する為のインターフェース定義
// ConcreateStrategy: 具体的戦略を決定
// Context : Strategyを利用する役

// メリット
// - アルゴリズムの部分を他の部分と意識的に分離。
// - プログラムから移譲によって、アルゴリズムを利用する為、柔軟にアルゴリズムを切り替えることが可能

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        Player player2 = new Player("Hana", new ProbStrategy(seed2));
        for (int i=0; i<10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total Result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
