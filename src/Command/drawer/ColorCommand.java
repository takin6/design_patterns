package Command.drawer;

import Command.command.Command;

import java.awt.*;

public class ColorCommand implements Command {
    protected Drawable drawable;
    private Color color;
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    public void execute() {
        drawable.setColor(color);
    }
}
