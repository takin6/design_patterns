package Command;

// Summary
// - 「この仕事を行いなさい」という「命令」を表現するクラス
// - 命令を表すクラスのインスタンスという１個の「もの」として表現することができる
// - CommandはEventと呼ばれる場合もある　ex) マウスをクリック、キーを押した
// - GUIに関わるプログラミングでは、イベントが登場する

// Actors
// - Command: 命令のAPIを定義
// - ConcreateCommand (MacroCommand, DrawCommand)
// - Receiver: Command役が命令を実行する時に対象となる役。命令の受取手。(DrawCanvas)
// - Client: ConcreteCommand役を生成し、その際にReceiver役を割り当てる役。 (Main)
// - Invoker: 命令の実行を開始する役(Main, DrawCanvas)

// Note
// - macroはプログラミングで、一般に複数の命令をまとめたものを意味する
// - java.awt.eventパッケージにはアダプターと呼ばれるクラス群がある。(Adapterパターン)

import Command.command.Command;
import Command.command.MacroCommand;
import Command.drawer.ColorCommand;
import Command.drawer.DrawCanvas;
import Command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton  = new JButton("clear");

    private JButton undoButton = new JButton("undo");

    private JButton redButton = new JButton("red");
    private JButton greenButton = new JButton("green");
    private JButton blueButton = new JButton("blue");

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.init();
            canvas.repaint();
        } else if (e.getSource() == redButton) {
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == greenButton) {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == blueButton) {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
