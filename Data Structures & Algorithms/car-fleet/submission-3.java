class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        for (int pos : position) {
            arr.add(pos);
        }

        Collections.sort(arr, Collections.reverseOrder());

        for (int index : arr) {
            System.out.println(index + " - " + map.get(index));
        }

        // we can add the time period in the stack
        ArrayList<Double> stack = new ArrayList<Double>();
        stack.add((double) ((target - arr.get(0)) / map.get(arr.get(0))));


        for (int i = 1; i < arr.size(); i++) {
            System.out.println("position" + " " + arr.get(i) + " " + "is being processed. The top most element of the stack is" + " " + stack.get(stack.size() - 1));
            double speedge = (double) (target - arr.get(i)) / map.get(arr.get(i));
            System.out.println(speedge);

            if (speedge > stack.get(stack.size() - 1)) {
                stack.add(speedge);
            }
        }

        return stack.size();
    }
}
