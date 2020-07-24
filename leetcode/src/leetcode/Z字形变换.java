package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/13 17:09
 * 2
 */
public class Z字形变换 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=numRows;i++){
            if(i == 1 || i == numRows){
                for(int j=i-1;j<s.length();j+=2*(numRows-1))
                    str.append(s.charAt(j));
            }else{
                int column = 0;
                int j=i-1;
                while(j<s.length()){
                    str.append(s.charAt(j));
                    if(column % 2 == 0){
                        column++;
                        j+=2*(numRows-i);
                    }else{
                        column++;
                        j+=2*(i-1);
                    }
                }
            }
        }
        return str.toString();
    }

}
