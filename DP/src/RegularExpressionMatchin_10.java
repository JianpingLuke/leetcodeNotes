/*
* https://leetcode.com/problems/regular-expression-matching/
* 10. Regular Expression Matching
* key :
* */

public class RegularExpressionMatchin_10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();
            boolean firstMatch = (!s.isEmpty()) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
            if (p.length()>=2 && p.charAt(1) == '*') return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)); //把*去掉，或复制直到第一个字幕不相等
            else return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
    /*
    * dp的思想，但用迭代看起来更简洁
    * 相当于每个函数只比较第一位，第二位就进入迭代了
    * */

    class Solution2 {
        public boolean isMatch2(String s, String p) {
            int len1 = s.length(), len2 = p.length();
            boolean dp[][] = new boolean[len1+1][len2+1]; // dp的正反选择对简化计算尤为关键
            dp[len1][len2] = true;
            for (int i = len1; i>=0; i--) {
                for (int j = len2; j>=0; j--) {
                    boolean firstMatch = (i<len1 && s.charAt(i) == p.charAt(j)) || p.charAt(j) == '*';
                    if(j+1 < len2 && p.charAt(j+1) == '*') dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                    else dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
            return dp[0][0];
        }
    }
    /*
    * 此时dp更像是硬生生地搬照来的
    * 由此可见，迭代和dp可以相互转换
    * O(n^2) O(n^2)
    * */
}
