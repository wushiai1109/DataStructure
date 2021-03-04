/**
 * @ClassName JZ2替换空格
 * @Description 本题知识点： 字符串
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author Bruce
 * @Date 2021/2/13 下午1:20
 */
public class JZ2替换空格 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.toString().length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
