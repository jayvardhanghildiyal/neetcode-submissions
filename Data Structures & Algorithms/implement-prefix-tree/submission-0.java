class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();    
    }

    public void insert(String word) {
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
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }

        return true;
    }
}
