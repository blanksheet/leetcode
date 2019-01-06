/**
 * Created by tianze
 * 2019/1/6 15:04
 */
public class isNumeric {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
