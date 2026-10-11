class CountSquares {
    Map<Integer, Map<Integer, Integer>> ptsCount;

    public CountSquares() {
        ptsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        ptsCount.putIfAbsent(x, new HashMap<>());
        // increment count
        ptsCount.get(x).put(y, ptsCount.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if (!ptsCount.containsKey(x1)) {
            return res;
        }

        for (int y2 : ptsCount.get(x1).keySet()) {
            int side = y2 - y1;

            if (side == 0) {
                continue;
            }

            int x3 = x1 + side, x4 = x1 - side;
            
            if (ptsCount.containsKey(x3)) {
                res += ptsCount.get(x1).get(y2) * ptsCount.get(x3).getOrDefault(y2, 0) * ptsCount.get(x3).getOrDefault(y1, 0);
            }

            if (ptsCount.containsKey(x4)) {
                res += ptsCount.get(x1).get(y2) * ptsCount.get(x4).getOrDefault(y2, 0) * ptsCount.get(x4).getOrDefault(y1, 0);
            }
            
        }

        return res;
    }
}

// x3, y1     x1, y1
// x3, y2     x1, y2

// x1, y1     x4, y1
// x1, y2     x4, y2
