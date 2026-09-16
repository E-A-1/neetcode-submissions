class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int combOne = 0;
        if (s1.length() > s2.length()) {
            return false;
        }
        for (char c: s1.toCharArray()) {
            int val = c;
            combOne+= val;
        }

        for (int j=0; j<s2.length(); j++) {
            int currentWindowValue = 0;
            if (((j+(s1.length())) > s2.length())) {
                break;
            }
            for (int i = j; i< (j+s1.length()); i++) {
                int val = s2.charAt(i);
                currentWindowValue+=val;
            }
            if (currentWindowValue == combOne) {
                return true;
            }
        }

        return false;
    }
}
