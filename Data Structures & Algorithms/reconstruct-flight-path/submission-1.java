class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> arr : tickets) {
            map.computeIfAbsent(arr.get(0), key -> new PriorityQueue<>()).offer(arr.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String str = stack.peek();

            if (!map.containsKey(str) || map.get(str).size() == 0) {
                ans.addFirst(stack.pop());
            } else {
                stack.push(map.get(str).poll());
            }
        }
        
        return ans;
    }
}
