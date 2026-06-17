class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        char ch[] = s.toCharArray();
        while(i<j) {
         if (!Character.isLetterOrDigit(ch[i])) {
            i++;
            continue;
         }
         else if (!Character.isLetterOrDigit(ch[j])) {
            j--;
            continue;
         }
         char left = Character.toLowerCase(ch[i]);
         char right = Character.toLowerCase(ch[j]);
         if(left == right) {
            i++;
            j--;
         }
         else {
            return false;
         }
        }

        return true;
    }
}
