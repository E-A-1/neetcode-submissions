class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i<s.length(); i++) {
            count += isPalindrome(s, i, i);
            count += isPalindrome(s, i, i+1);
        }

        return count;
    }

    private int isPalindrome(String s, int l, int r) {
            int res = 0;
            while (l>=0 && r<s.length() 
                && s.charAt(l) == s.charAt(r)
            ) {
                res++;
                l--;
                r++;
            }  

            return res;   
    }
}
