class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
// memo[i][j] will store whether s1[i...] and s2[j...] can interleave s3[i+j...]

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0,0,0,s1,s2,s3,memo);
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3, Boolean[][] memo) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
boolean res = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || dfs(i + 1, j, k + 1, s1, s2, s3, memo);
        }

        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || dfs(i, j + 1, k + 1, s1, s2, s3, memo);
        }

        return memo[i][j] = res;
    }
}
