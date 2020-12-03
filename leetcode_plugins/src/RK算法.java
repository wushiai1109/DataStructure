import static java.util.Objects.hash;

/**
 * @ClassName RK算法
 * @Description
 * @Author Bruce
 * @Date 2020/11/12 8:27 下午
 */
public class RK算法 {
    //Time Complexity O(n)
    public int rabinKarp(String str, String pattern) {
        //主串长度
        int strLen = str.length();
        //模式串的长度
        int patternLen = pattern.length();
        //计算模式串的hash值
        int patternHashCode = hash(pattern);
        //计算主串当中第一个和模式串等长的子串hash值
        int strHashCode = hash(str.substring(0, patternLen));
        //用模式串的hash值和主串的局部hash值比较。
        //如果匹配，则进行精确比较；如果不匹配，计算主串中相邻子串的hash值。
        for (int i = 0; i < strLen - patternLen + 1; i++) {
            if (strHashCode == patternHashCode && compareString(i, str, pattern)) {
                return i;
            }
            //如果不是最后一轮，更新主串从i到i+n的hash值
            if (i < strLen - patternLen) {
                strHashCode = nextHash(str, strHashCode, i, patternLen);
            }
        }
        return -1;
    }

    private int hash(String str) {
        int hashcode = 0;
        //这里采用最简单的hashcode计算方式：
        // 把a当做1，把b当中2，把c当中3.....然后按位相加
        for (int i = 0; i < str.length(); i++) {
            hashcode += str.charAt(i) - 'a';
        }
        return hashcode;
    }

    private int nextHash(String str, int strHashCode, int index, int patternLen) {
        return strHashCode - (str.charAt(index) - 'a') + (str.charAt(index + patternLen) - 'a');
    }

    private boolean compareString(int i, String str, String pattern) {
        String strSub = str.substring(i, i + pattern.length());
        return strSub.equals(pattern);
    }

    public static void main(String[] args) {
        String str = "aacdesadsdfer";
        String pattern = "adsd";
        System.out.println(new RK算法().rabinKarp(str, pattern));
    }
}