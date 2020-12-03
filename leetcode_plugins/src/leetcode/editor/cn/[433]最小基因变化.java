package leetcode.editor.cn;//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 49 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class 最小基因变化433 {
    /// Bi-directional BFS 双向BFS
/// No need to calculate all pairs similarity
/// Time Complexity: O(n*n)
/// Space Complexity: O(n)
    public int minMutation(String start, String end, String[] bank) {

        List<String> list = Arrays.asList(bank);

        if (!list.contains(end)) {
            return -1;
        }

        // bi-derectional-bfs
        LinkedList<String> qStart = new LinkedList<>();
        LinkedList<String> qEnd = new LinkedList<>();

        HashMap<String, Integer> hStart = new HashMap<>();
        HashMap<String, Integer> hEnd = new HashMap<>();

        qStart.addLast(start);
        hStart.put(start, 1);

        qEnd.addLast(end);
        hEnd.put(end, 1);

        while (!qStart.isEmpty() && !qEnd.isEmpty()) {

            String curStartWord = qStart.removeFirst();
            String curEndWord = qEnd.removeFirst();
            for (String word : list) {
                if (!hStart.containsKey(word) && similar(word, curStartWord)) {
                    hStart.put(word, hStart.get(curStartWord) + 1);
                    qStart.addLast(word);
                }

                if (!hEnd.containsKey(word) && similar(word, curEndWord)) {
                    hEnd.put(word, hEnd.get(curEndWord) + 1);
                    qEnd.addLast(word);
                }
            }

            // check intersection相交
            int res = Integer.MAX_VALUE;
            for (String word : list) {
                if (hStart.containsKey(word) && hEnd.containsKey(word)) {
                    res = Integer.min(res, hStart.get(word) + hEnd.get(word) - 1);
                }
            }

            if (res != Integer.MAX_VALUE) {
                return res - 1;
            }
        }
        return -1;
    }

    private boolean similar(String word1, String word2) {

        if (word1.length() != word2.length() || word1.equals(word2)) {
            throw new IllegalArgumentException();
        }

        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

//    int minStepCount = Integer.MAX_VALUE;
//
//    public int minMutation(String start, String end, String[] bank) {
//        dfs(new HashSet<String>(), 0, start, end, bank);
//        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
//    }
//
//    private void dfs(HashSet<String> hashSet, int stepCount, String cur, String end, String[] bank) {
//        if (cur.equals(end)) {
//            minStepCount = Math.min(stepCount, minStepCount);
//        }
//        for (String str : bank) {
//            int diff = 0;
//            for (int i = 0; i < str.length(); i++) {
//                if (cur.charAt(i) != str.charAt(i)) {
//                    if (++diff > 1) {
//                        break;
//                    }
//                }
//            }
//            if (diff == 1 && !hashSet.contains(str)) {
//                hashSet.add(str);
//                dfs(hashSet, stepCount + 1, str, end, bank);
//                hashSet.remove(str);
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
