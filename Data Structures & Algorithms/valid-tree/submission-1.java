class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        if (!bfs(0, -1)) {
            return false;
        }

        return set.size() == n;
    }

    public boolean dfs(int vertex, int parent) {
        if (set.contains(vertex)) {
            return false;
        }

        set.add(vertex);
        for (int v : map.get(vertex)) {
            if (v == parent) {
                continue ;
            } else if (!dfs(v, vertex)) {
                return false;
            }
        }
        
        return true;
    }

    public boolean bfs(int vertex, int parent) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{vertex, parent});
        set.add(vertex);

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int v = node[0], p = node[1];

            for (int nei : map.get(v)) {
                if (nei == p) {
                    continue ;
                } else if (set.contains(nei)) {
                    return false;
                }

                q.offer(new int[]{nei, v});
                set.add(nei);
            }
        }

        return true;
    }
}
