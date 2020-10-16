package Proxy;

// 名前付きのプリンターを表すクラス（代理人）
public class PrinterProxy implements Printable {
    private String name;
    private Printable real; //本人
    private String classname;
    public PrinterProxy() {}
    public PrinterProxy(String name, String classname) {
        this.name = name;
        this.classname = classname;
    }

    // Printerのインスタンスは生成されない
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            try {
                real = (Printable) Class.forName(classname).newInstance();
                real.setPrinterName(name);
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
//            real = new Printer(name);
        }
    }

}
