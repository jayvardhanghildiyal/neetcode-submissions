class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>(); 
    private Set<Integer> visitedSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int j = 0; j < numCourses; j++) {
            map.put(j, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int courseNum) {
        if (visitedSet.contains(courseNum)) {
            return false;
        } else if (map.get(courseNum).size() == 0) {
            return true;
        }

        visitedSet.add(courseNum);

        for (int prereq : map.get(courseNum)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visitedSet.remove(courseNum);
        map.put(courseNum, new ArrayList<>());
        return true;
    }
}
