package Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private String extension;
    private List foundFiles = new ArrayList<File>();

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }

    public Iterator getFoundFiles() {
        return foundFiles.iterator();
    }
}
