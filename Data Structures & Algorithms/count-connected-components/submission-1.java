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
                dfs(j, -1);
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
}
