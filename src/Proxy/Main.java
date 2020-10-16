package Proxy;

// Summary
// - Proxy: 仕事を行うべき本人の代わりとなる人。本人でなくてもできるような仕事を代理人に任せる
// - 忙しくてその仕事ができない本人オブジェクトの代わりに、代理人オブジェクトが仕事をこなしてやること

// Actors
// - Subject: ProxyとRealSubjectを同一視するためのAPI。ClientはProxyとRealSubjectの違いを意識する必要がなくなる
// - Proxy: Client役からの要求をできるだけ処理
// - RealSubject: 代理人のProxy役では手に負えなくなった時に登場するのが「本人」のRealSubject役
// - Client: Proxyパターンを利用する役

// Note
// - 代理人を使ってスピードアップ。重い処理（インスタンス生成など）を遅らせる
// - 使用例：文書中にグラフィックオブジェクトを埋め込むような文書エディタ。個々のグラフィックオブジェクトを画面に表示する時になってから生成する
// - 使用例2: HTTP Proxyのキャッシュ機能。Client: Webブラウザ、Proxy: HTTP Proxy、ReacSubject: Webサーバー
// - Proxyの様々なパターン
//   - Virtual Proxy : 本当にインスタンスが必要になった時点で、生成・初期化を行う
//   - Remote Proxy: RealSubjectがネットワークの向こう側にいるにもかかわらず、あたかも自分のそばにいるように透過的にメソッド呼び出しができる
//   - Access Proxy: RealSubject役の機能に対して、アクセス制限を設ける。定められたユーザーならメソッド呼び出しを許可するが、それ以外はエラーになるような処理

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice", "Proxy.Printer");
        System.out.println("名前は現在" + p.getPrinterName() + "です");
        p.setPrinterName("Bob");
        System.out.println("名前は現在" + p.getPrinterName() + "です");
        p.print("Hello World");
    }
}
