class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxStreak = 0;
        char input[] = s.toCharArray();
        HashSet<Character> sett = new HashSet<>();
        int l = 0;
        for (int r = 0; r<s.length(); r++) {
            while(sett.contains(s.charAt(r))) {
                sett.remove(s.charAt(l));
                l++;
            }
            sett.add(s.charAt(r));
            maxStreak = Math.max(maxStreak, r - l + 1);
        }
        return maxStreak;
    }
}
