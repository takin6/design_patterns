package State;

// Summary
// Stateパターン：「状態」をクラスとして表現。クラスを切り替えることによって、「状態の変化」が表せる。
//               新しい状態を追加しなければならない時に、何をプログラムすれば良いのかがはっきりします。
//
// Actors
// State役：状態を表すためのもの。状態ごとに異なる振る舞いをするAPIを定める。(State interface)
// ConcreteState:
// Context: 現在の状態を表すConcreteState役をもつ。Stateパターンの利用者に必要なAPIを定める

// Note
// - 状態に依存した処理を、stateに移譲できる。

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour=0; hour<24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {}
            }
        }
    }
}
