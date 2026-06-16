class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);

            boolean[] visit = new boolean[n + 1];

            if (dfs(e[0], -1, visit)) {
                return e;
            }
        }

        return new int[0];
    }

    public boolean dfs (int vertex, int parent, boolean[] visit) {
        if (visit[vertex]) {
            return true;
        }
        
        visit[vertex] = true;

        for (int nei : map.get(vertex)) {
            if (nei == parent) {
                continue;
            } else if (dfs(nei, vertex, visit)) {
                return true;
            }
        }

        return false;
    }
}
