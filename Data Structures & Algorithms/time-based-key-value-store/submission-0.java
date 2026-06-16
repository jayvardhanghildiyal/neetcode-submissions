class TimeMap {

    private HashMap<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if (!map.containsKey(key)) {
        //     map.put(key, new ArrayList<>());
        // } else {
        //     map.get(key).add(new Pair<>(timestamp, value));
        // }
         map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> arr = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = arr.size() - 1;

        String answer = "";

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr.get(mid).getKey() <= timestamp) {
                answer = arr.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
