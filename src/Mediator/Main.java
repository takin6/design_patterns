package Mediator;

// Summary
// Mediator pattern: メンバーはみんな相談役だけに報告し、メンバーへの指示は相談役だけから来る
//                   Mediator (相談役)、Colleague (同僚)

// Actor
// Mediator: Colleague役と通信を行って、調整をおkなう為のAPIを定める
// ConcreteMediator: 具体的なMediator役のAPIを実装
// Colleague: Mediator役と通信を行うAPIを規定
// ConcreteColleague: Colleague役のAPIを実装

// Note
// - 表示の有効・無効に関するロジックは、login frame以外に存在しない為、デバッグする箇所が少なく済む
// - 複雑に絡み合うオブジェクトたち相互の通信をやめ、Mediatorやくに情報を集中させることによって処理を整理する。
//   GUIアプリケーションで特に効果的なパターン

public class Main {
    public static void main(String[] args) {
        new LoginFrame("Mediator Sample");
    }
}
