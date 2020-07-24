package SegmentTree;

/**
 * @author Wushiai
 * @date 2020/2/7 22:47
 * @content
 */
public interface Merger<E> {
    E merge(E a, E b);
}
