/**
 * @ClassName ab同学在n个汉堡中找到各自喜欢的一个汉堡的概率
 * @Description a同学，b同学，同时买了n个汉堡， 老板每次做汉堡是随机的，有j个面包，k个香料。 aj bj tj 为a不喜欢的面包种数，
 * b不喜欢的面包种数， ab都不喜欢的面包种数 ak， bk， tk 为a不喜欢的香料种数， b不喜欢的香料种数， ab都不喜欢的香料种数。
 * 求a.b可以在n个汉堡中找到各自喜欢的一个汉堡的概率。 例如n = 2 ， j= 3， k=3， 1 1 1 、1 1 1 概率为16/81
 * @Author Bruce
 * @Date 2020/7/17 8:42 下午
 */
public class ab同学在n个汉堡中找到各自喜欢的一个汉堡的概率 {
    public static void main(String[] args) {
        System.out.println(new ab同学在n个汉堡中找到各自喜欢的一个汉堡的概率().nextPermutation(2, 3, 3, 1, 1, 1, 1, 1, 1));
    }

    public String nextPermutation(int n, int j, int k, int aj, int bj, int tj, int ak, int bk, int tk) {

        return "";
    }
}
