class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> response = new ArrayList<>();
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<ch.length;i++) {
            char c = ch[i];
            map.put(c, i);
        }
        int size = 0;
        int end = 0;

        for (int i = 0; i<ch.length;i++) {

            end = Math.max(map.get(ch[i]), end);
            size++;
            if (i == end) {
                response.add(size);
                size = 0;
            }
        }

        return response;
    }
}
