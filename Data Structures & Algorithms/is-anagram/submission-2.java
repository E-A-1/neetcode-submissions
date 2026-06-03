class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i=0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            sMap.put(a, sMap.getOrDefault(a, 0) + 1);
            tMap.put(b, tMap.getOrDefault(b, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
