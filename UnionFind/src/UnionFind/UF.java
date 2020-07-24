package UnionFind;

/**
 * @author Wushiai
 * @date 2020/2/9 19:35
 * @content
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}
