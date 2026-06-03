class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (String st: strs) {
            char[] charArray = st.toCharArray();
            Arrays.sort(charArray);
            String uniqueKey = new String(charArray);
            if(group.containsKey(uniqueKey)) {
                group.get(uniqueKey).add(st);
            } else {
                group.put(uniqueKey, new ArrayList<>(List.of(st)));
            }
        }
      for (Map.Entry<String, List<String>> entry: group.entrySet()) {
            list.add(entry.getValue());
      } 
      return list;
    }
}
