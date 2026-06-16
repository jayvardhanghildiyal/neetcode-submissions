class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int d;

        for (int[] arr : points) {
            d = arr[0] * arr[0] + arr[1] * arr[1];
            q.add(new int[] {d, arr[0], arr[1]});
        }

        int[][] answer = new int[k][2];
        int pointer = 0;
        while (q.size() > points.length - k) {
            int[] temp = q.poll();
            answer[pointer] = new int[]{temp[1], temp[2]};
            pointer += 1;
        }

        return answer;
    }
}
