class Solution {
    public String minWindow(String s, String t) {
        int response[] = {-1,-1};
        int min = Integer.MAX_VALUE;
        Map<Character,Integer> cMap = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        if (s.length() < t.length()) {
            return "";
        }
        for (char c : t.toCharArray()) {
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }

        int needs = cMap.size();
        int have = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char current = s.charAt(r);
            if (cMap.containsKey(current)) {
                window.put(current, window.getOrDefault(current, 0) + 1);
            }
            if (cMap.containsKey(current) && (cMap.get(current).equals(window.get(current)))) {
                have++;
            }
            
            while (have == needs) {
                if ((r-l+1) <min) {
                    min = r-l+1;
                    response[0] = l;
                    response[1] = r;
                }
                char left = s.charAt(l);
                if (window.containsKey(left)) {
                   window.put(left, window.get(left)-1);
                }
                if(cMap.containsKey(left) && (window.get(left)<cMap.get(left))) {
                    have--;
                }
                l++;
            }

            r++;

        }
        String val = "";
        if (min!=Integer.MAX_VALUE) {
            val = s.substring(response[0],response[1]+1);
        }

        return val;
    }
}
