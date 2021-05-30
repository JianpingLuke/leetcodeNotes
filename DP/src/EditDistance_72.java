public class EditDistance_72 {
    class Solution { // dp table 的方法
        public int minDistance(String word1, String word2) {
            int len1 = word1.length(), len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0) dp[0][j] = j;
                    else if (j == 0) dp[i][0] = i;
                    else if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else {
                        int insert = dp[i][j-1] + 1;
                        int delete = dp[i-1][j] + 1;
                        int replace = dp[i-1][j-1] + 1; // 替换相当于减去再插入，但只有一次操作
                        dp[i][j] = Math.min(insert, Math.min(delete, replace));
                    }
                }
            }
            return dp[len1][len2];
        }
    }

    class Soultion2 { // 利用回溯法，减去了不必要的计算，减少了所需的运算时间
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][]dp = new int[m+1][n+1];
            return editDistance(word1,word2,m,n,dp);
        }

        int editDistance(String word1, String word2,int i, int j, int[][]dp){
            if(i==0) return j;
            if(j==0) return i;
            if(dp[i][j] != 0) return dp[i][j];
            if(word1.charAt(i-1) == word2.charAt(j-1)) return dp[i][j] = editDistance(word1,word2,i-1,j-1,dp); // 易错！ dp[i][j] 是charAt i-1 和 j-1
            int insert = editDistance(word1,word2,i,j-1,dp);
            int delete = editDistance(word1,word2,i-1,j,dp);
            int replace = editDistance(word1,word2,i-1,j-1,dp);

            return dp[i][j] = Math.min(Math.min(insert,delete),replace)+1; // 技巧，返回的同时给dp赋值
        }
    }
}
