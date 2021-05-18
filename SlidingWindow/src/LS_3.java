import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* https://leetcode.com/problems/longest-substring-without-repeating-characters/
* 3. Longest Substring Without Repeating Characters
* key : sliding window
* */

public class LS_3 {
    class Solution1 {
        public int LS(String s) {
            if (s.length() == 0) return  0;
            Map<Character, Integer> dicts = new HashMap<>();
            int r = 0, l = 0, len = 1, max = -1;
            while (r < s.length()) {
                char c = s.charAt(r);
                int count = dicts.getOrDefault(c, 0);
                dicts.put(c, count + 1);
                while(dicts.get(c).intValue() > 1) {
                    int num = dicts.get(s.charAt(1)).intValue();
                    dicts.put(s.charAt(1), num -1);
                    l++;
                }
                len = r - l + 1;
                if (len > max) max = len;
                r++;
            }
            return  max;
        }
    }

    class  Solution2 {
        public int LS2(String s) {
            if (s == null) return 0;
            Set<Character> set = new HashSet<>();
            int l = 0, r = 0, res = 0;
            while (l <s.length()) {
                if (!set.add(s.charAt(r))) { set.remove(s.charAt(l)); l++; } // set判断唯一性的应用
                else { res = Math.max(res, set.size()); r++; } // 直接用Math.max()简化了反复赋值给max的步骤
            }
            return res;
        }
    }
}

/*
* 滑动窗口，先设定边界再判断
* 相比而言，要判断唯一性，用set比map简单的多
* O(n)  <O(n)
* */
