class Solution {
    public boolean updateMap(HashMap<Integer, Integer> map, int groupSize) {
        // finding the smallest number in the hashmap
        int min = 1001;
        for (int num : map.keySet()) {
            if (num < min && map.get(num) >= 1) {
                min = num;
            }
        }

        if (min == 1001) {
            return false;
        }

        // update map by reducing consecutive values
        int count = groupSize;
        int start = min;
        while (count > 0) {
            if (map.containsKey(start) && map.get(start) >= 1) {
                map.put(start, map.get(start) - 1);
            } else {
                return false;
            }
            start += 1;
            count -= 1;
        }
        return true;
 
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // add hand to the map
        for (int num : hand) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        System.out.println(map);

        int answer = hand.length / groupSize;
        while (updateMap(map, groupSize)) {
            answer -= 1;
        }

        return answer == 0 ? true : false;
    }
}
