class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0, index = 0;
        for (int i=0; i<s.length(); i++) {
            // odd length
            int l = i, r = i;
            while (l>=0 && r<s.length() 
                && s.charAt(l) == s.charAt(r)
            ) {
                if (((r-l+1) > resLen)) {
                    resLen = r-l+1;
                    index = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while (l>=0 && r<s.length() 
                && s.charAt(l) == s.charAt(r)
            ) {
                if (((r-l+1) > resLen)) {
                    resLen = r-l+1;
                    index = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(index, index+resLen);
    }
}
