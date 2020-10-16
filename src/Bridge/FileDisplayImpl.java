package Bridge;

import java.io.*;

public class FileDisplayImpl extends DisplayImpl {
    private String filename;
    private BufferedReader filereader;
    public FileDisplayImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public void rawOpen() {
        try {
            filereader = new BufferedReader( new FileReader(filename) );
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawPrint() {
        try {
            String str = filereader.readLine();
            while (str != null) {
                System.out.println(str);
                str = filereader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void rawClose() {
        try {
            filereader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
