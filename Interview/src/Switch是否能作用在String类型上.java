/**
 * @author Wushiai
 * @date 2020/2/20 20:38
 * @content switch 语句中的变量类型可以是：byte、short、int 或者 char。
 * 从 Java SE 7 开始，switch 支持字符串 String 类型了，同时 case 标签必须为字符串常量或字面量。
 * String是引用数据类型，底层是char数组实现的
 */
public class Switch是否能作用在String类型上 {
    public static void main(String[] args) {
        String[] strs = {"aaa", "bbb", "ccc", "ddd"};
        for (int i = 0; i < strs.length; i++) {
            switch (strs[i]){
                case "aaa":
                    System.out.println("aaa");
                    continue;
                case "bbb":
                    System.out.println("bbb");
                    continue;
                case "ccc":
                    System.out.println("ccc");
                    continue;
                default:
                    System.out.println("ddd");
                    break;
            }
        }
    }
}
