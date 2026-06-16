class Solution {
    private Map<Integer, List<Integer>> map;
    private Set<Integer> set;
    private boolean[] visit;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        visit = new boolean[n + 1];
        set = new HashSet<>();
        cycleStart = -1;
        dfs(1, -1);

        for (int j = edges.length - 1; j >= 0; j--) {
            int u = edges[j][0], v = edges[j][1];
            if (set.contains(u) && set.contains(v)) {
                return new int[]{u, v};
            }
        }

        return new int[0];
    }

    public boolean dfs (int vertex, int parent) {
        if (visit[vertex]) {
            cycleStart = vertex;
            return true;
        }
        
        visit[vertex] = true;
        for (int nei : map.get(vertex)) {
            if (nei == parent) {
                continue;
            } else if (dfs(nei, vertex)) {
                if (cycleStart != -1) {
                    set.add(vertex);
                }
                if (vertex == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
