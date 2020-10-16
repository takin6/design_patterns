package Command.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
    private Stack commands = new Stack();

    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }

    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    // 最後の命令を削除
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
