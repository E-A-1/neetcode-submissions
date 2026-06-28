class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char c[] = s1.toCharArray();
        Arrays.sort(c);
        String sortedOne = Arrays.toString(c);
        int l=0;
        int r=s1.length()-1;
        while ( r < s2.length()) {
            char c1[] = new char[s1.length()];
            for (int i = 0; i<s1.length(); i++) {
                c1[i] = s2.charAt(i+l);
            }
            Arrays.sort(c1);
            String secondSorted = Arrays.toString(c1);

            if (sortedOne.equals(secondSorted)) {
                return true;
            }
            l++;
            r++;
        }


        return false;
    }
}
