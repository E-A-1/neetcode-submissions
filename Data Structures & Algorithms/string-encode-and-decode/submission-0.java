class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String st: strs) {
            encodedString.append(st.length()).append('#').append(st);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while(i<str.length()) {
            int j = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            String word = str.substring(i, i+length);
            decodedString.add(word);
            i = i+ length; 
        }
    return decodedString;
    }
}
