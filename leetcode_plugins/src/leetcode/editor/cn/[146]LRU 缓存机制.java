package leetcode.editor.cn;//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1112 👎 0


import javax.swing.text.html.HTMLDocument;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
//LRUCache缓存机制146
class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (list.containsKey(key)) {
            int value = list.get(key);
            list.remove(key);
            list.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (list.containsKey(key)) {
            list.remove(key);
        } else if (list.size() == capacity) {
            //1、当创建完成指向某个集合或者容器的Iterator对象时，这时的指针其实指向的是第一个元素的上方，即指向一个 空
            //2、当调用hasNext方法的时候，只是判断下一个元素的有无，并不移动指针
            //3、当调用next方法的时候，向下移动指针，并且返回指针指向的元素，如果指针指向的内存中没有元素，会报异 常。
            //4、remove方法删除的元素是指针指向的元素。如果当前指针指向的内存中没有元素，那么会抛出异常。
            Iterator<Map.Entry<Integer,Integer>> iterator = list.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        list.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
