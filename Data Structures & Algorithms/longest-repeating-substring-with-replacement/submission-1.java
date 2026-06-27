class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0;
        int max = 0;
        int res = 1;
        // Sliding Window Optimal Solution
        for (int r=0; r<s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            max = Math.max(max, map.get(s.charAt(r)));
            while( ((r-l+1)- max) > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }

            res = Math.max(r-l+1, res);
        }

        return res;
    }
}
