package leetcode.editor.cn;//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 516 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 复原IP地址93 {
    public static void main(String[] args) {
        System.out.println(new 复原IP地址93().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        restoreIpAddresses(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void restoreIpAddresses(String s, int index, List<String> list, List<String> result) {
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数
        int maxLength = (4 - list.size()) * 3;
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求
        if (s.length() - index > maxLength) {
            return;
        }

        // 满足条件
        if (list.size() == 4 && s.length() == index) {
            // 拼接处结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append(list.get(i));
                } else {
                    sb.append(".").append(list.get(i));
                }
            }
            result.add(sb.toString());
        }

        for (int i = index; i < index + 3 && i < s.length(); i++) {
            //subString左闭右开，索引从0开始
            String ip = s.substring(index, i + 1);
            // 大于255 不符合ip规则
            if (Integer.parseInt(ip) > 255) {
                continue;
            }
            // 大于1位数时 0不能为头
            if (ip.length() > 1 && "0".equals(ip.substring(0, 1))) {
                continue;
            }
            list.add(ip);
            restoreIpAddresses(s, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
