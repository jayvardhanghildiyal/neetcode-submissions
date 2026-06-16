class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> set = new HashSet<>();
    private List<Integer> ans = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        for (int j = 0; j < numCourses; j++) {
            if (!dfs(j)) {
                return new int[0];
            }
        }

        int[] answer = new int[numCourses];
        for (int k = 0; k < numCourses; k++) {
            answer[k] = ans.get(k);
        }

        return answer;
    }

    public boolean dfs(int courseNum) {
        if (set.contains(courseNum)) {
            return false;
        } else if (map.get(courseNum).size() == 0) {
            if (!ans.contains(courseNum)) {
                ans.add(courseNum);
            }
            return true;
        }

        set.add(courseNum);

        for (int prereq : map.get(courseNum)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        set.remove(courseNum);
        map.put(courseNum, new ArrayList<>());
        ans.add(courseNum);

        return true;
    }
}
