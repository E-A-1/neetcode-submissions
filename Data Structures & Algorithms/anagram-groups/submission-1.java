class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String st: strs) {
            char[] charr = st.toCharArray();
            Arrays.sort(charr);
            String sorted = new String(charr);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(st);
        }
        return new ArrayList<>(map.values());
    }
}
