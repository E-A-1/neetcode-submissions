public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int k, String word, TrieNode root) {
        TrieNode current = root;
        for (int i=k;i<word.length();i++) {
            if (word.charAt(i) == '.') {
                for (TrieNode child: current.children.values()) {
                    if (dfs(i+1, word, child)) {
                        return true;
                    }
                }
                return false;

            }
            else {
                if (!current.children.containsKey(word.charAt(i))) {
                    return false;
                }
                else {
                    current = current.children.get(word.charAt(i));
                }
            }
        }

        return current.endOfWord;
    }
}
