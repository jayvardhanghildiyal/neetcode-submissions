class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}

class WordDictionary {
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return bt(word, root);
    }

    public boolean bt(String word, TrieNode root) {
        TrieNode curr = root;
        int i = 0;

        for (char c : word.toCharArray()) {
            if (c == '.') {
                for (char ch : curr.children.keySet()){
                    if (bt(word.substring(i + 1), curr.children.get(ch)) == false) {
                        continue;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
            i += 1;
        } 

        return curr.end;
    }
}
