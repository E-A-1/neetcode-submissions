class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i=0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (sMap.containsKey(a)) {
                int value = sMap.get(a) + 1;
                sMap.put(a, value);
            }
            else {
                sMap.put(a, 1);
            }
        }
        for (int i=0; i < t.length(); i++) {
            char a = t.charAt(i);
            if (tMap.containsKey(a)) {
                int value = tMap.get(a) + 1;
                tMap.put(a, value);
            }
            else {
                tMap.put(a, 1);
            }
        }
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
            Integer value = entry.getValue();
            Integer tMapValue = tMap.get(entry.getKey());
            if (tMapValue == null) {
                return false;
            }
            if (!value.equals(tMapValue)) {
                return false;
            }
        }

        return true;
    }
}
