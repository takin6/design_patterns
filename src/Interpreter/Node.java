package Interpreter;

// 構文木の各部分(ノード)を構成する最上位のクラス
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
