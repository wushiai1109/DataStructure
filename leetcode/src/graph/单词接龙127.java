package graph;

import java.util.*;

/**
 * @author Wushiai
 * @date 2020/3/27 20:46
 * @content 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class 单词接龙127 {

    public static void main(String[] args) {
        String[] str = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(str));
        System.out.println(new 单词接龙127().ladderLength("qa", "sq", wordList));

//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        String[] str = {"hot", "dot", "dog", "lot", "log", "cog"};
//        List<String> wordList = new ArrayList<>();
//        wordList.addAll(Arrays.asList(str));
//        System.out.println(new 单词接龙127().ladderLength("hit", "cog", wordList));
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        Queue<String> queue = new LinkedList<>();
//        Set<String> set = new HashSet<>();
//
//        queue.offer(beginWord);
//        for (int i = 2; !queue.isEmpty(); i++) {
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                //poll从队列中删除第一个元素
//                String str = queue.poll();
//                set.add(str);
//                wordList.remove(str);
//                for (String s : wordList)
//                    if (!set.contains(s) && isNeighbor(str, s))
//                        if (s.equals(endWord))
//                            return i; //Found it!
//                        else
//                            queue.offer(s);
//            }
//        }
//        return 0;
//    }
//
//    private boolean isNeighbor(String str1, String str2) {
//        int length = str1.length();
//        int diff = 0;
//
//        for (int i = 0; i < length; i++)
//            if (str1.charAt(i) != str2.charAt(i)) {
//                diff++;
//                if (diff > 1)
//                    return false;
//            }
//        return true;
//    }


    /// Bi-directional BFS
/// No need to calculate all pairs similarity
/// Time Complexity: O(n*n)
/// Space Complexity: O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // bi-derectional-bfs
        LinkedList<String> qStart = new LinkedList<>();
        LinkedList<String> qEnd = new LinkedList<>();

        HashMap<String, Integer> hStart = new HashMap<>();
        HashMap<String, Integer> hEnd = new HashMap<>();

        qStart.addLast(beginWord);
        hStart.put(beginWord, 1);

        qEnd.addLast(endWord);
        hEnd.put(endWord, 1);

        while (!qStart.isEmpty() && !qEnd.isEmpty()) {

            String curStartWord = qStart.removeFirst();
            String curEndWord = qEnd.removeFirst();
            for (String word : wordList) {
                if (!hStart.containsKey(word) && similar(word, curStartWord)) {
                    hStart.put(word, hStart.get(curStartWord) + 1);
                    qStart.addLast(word);
                }

                if (!hEnd.containsKey(word) && similar(word, curEndWord)) {
                    hEnd.put(word, hEnd.get(curEndWord) + 1);
                    qEnd.addLast(word);
                }
            }

            // check intersection
            int res = Integer.MAX_VALUE;
            for (String word : wordList) {
                if (hStart.containsKey(word) && hEnd.containsKey(word)) {
                    res = Integer.min(res, hStart.get(word) + hEnd.get(word) - 1);
                }
            }

            if (res != Integer.MAX_VALUE) {
                return res;
            }
        }
        return 0;
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

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        dfs(new HashSet<String>(), 0, beginWord, endWord, wordList);
//        return (minStepCount == Integer.MAX_VALUE) ? 0 : minStepCount;
//    }
//
//    int minStepCount = Integer.MAX_VALUE;
//
//    private void dfs(HashSet<String> hashSet, int stepCount, String cur, String end, List<String> wordList) {
//        if (cur.equals(end)) {
//            minStepCount = Math.min(stepCount+1, minStepCount);
//        }
//        for (String str : wordList) {
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
//                dfs(hashSet, stepCount + 1, str, end, wordList);
//                hashSet.remove(str);
//            }
//        }
//    }

}
