class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private int answer = 0;

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        for (int j = 0; j < n; j++) {
            if (!visited.contains(j)) {
                answer += 1;
                bfs(j, -1);
            }
        }

        return answer;
    }

    public void dfs(int vertex, int parent) {
        if (visited.contains(vertex)) {
            return ;
        }

        visited.add(vertex);

        for (int nei : map.get(vertex)) {
            if (nei == parent) {
                continue ;
            }
            dfs(nei, vertex);
        }
    }

    public void bfs(int vertex, int parent) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{vertex, parent});
        visited.add(vertex);

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int vert = node[0], par = node[1];
            for (int nei : map.get(vert)) {
                if (nei == par) {
                    continue ;
                } else if (visited.contains(nei)) {
                    continue ;
                }
                q.offer(new int[]{nei, vert});
                visited.add(nei);
            }
        }
    }
}
