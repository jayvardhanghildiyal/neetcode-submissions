/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> newNodes = new HashMap<>();

        return bfs(node, newNodes);
    }

    private Node dfs (Node node, Map<Node, Node> newNodes) {
        if (node == null) {
            return null;
        }

        if (newNodes.containsKey(node)) {
            return newNodes.get(node);
        }

        Node copy = new Node(node.val);
        newNodes.put(node, copy);
        
        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, newNodes));
        }

        return copy;
    }

    private Node bfs (Node node, Map<Node, Node> newNodes) {
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        newNodes.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            for (Node n : curr.neighbors) {
                if (!newNodes.containsKey(n)) {
                    newNodes.put(n, new Node(n.val));
                    q.add(n);
                }
                newNodes.get(curr).neighbors.add(newNodes.get(n));
            }
        }

        return newNodes.get(node);
    }
}