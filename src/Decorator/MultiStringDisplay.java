package Decorator;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display{
    List<StringDisplay> strings = new ArrayList<StringDisplay>();
    public MultiStringDisplay(){}

    public void add(String string) {
        strings.add(new StringDisplay(string));
    }

    @Override
    public int getColumns() {
        int result = 0;
        int cnt = strings.size();
        for (int i=0; i<cnt; i++) {
            result = Math.max(result, strings.get(i).getRowText(0).getBytes().length);
        }
        return result;
    }

    @Override
    public int getRows() {
        return strings.size();
    }

    @Override
    public String getRowText(int row) {
        return strings.get(row).getRowText(0);
    }
}
