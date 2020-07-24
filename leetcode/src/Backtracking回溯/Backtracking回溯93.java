package Backtracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/7 11:07
 * @content 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Backtracking回溯93 {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();


        restoreIpAddresses(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void restoreIpAddresses(String s, int index, List<String> list, List<String> result) {
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数
        int maxLength = (4 - list.size()) * 3;
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求
        if (s.length() - index > maxLength)
            return;

        // 满足条件
        if (list.size() == 4 && s.length() == index) {
            // 拼接处结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    sb.append(list.get(i));
                else
                    sb.append(".").append(list.get(i));
            }
            result.add(sb.toString());
        }

        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            //subString左闭右开，索引从0开始
            String ip = s.substring(index, i);
            // 大于255 不符合ip规则
            if (Integer.parseInt(ip) > 255)
                continue;
            // 大于1位数时 0不能为头
            if (ip.length() > 1 && "0".equals(ip.substring(0, 1)))
                continue;
            list.add(ip);
            restoreIpAddresses(s, i, list, result);
            list.remove(list.size() - 1);
        }
    }
}
