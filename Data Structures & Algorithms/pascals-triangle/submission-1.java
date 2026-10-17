class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                list.add(new ArrayList<>(Arrays.asList(1)));
            } else if (i == 1) {
                list.add(new ArrayList<>(Arrays.asList(1, 1)));
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                for (int j = 0; j < list.get(i - 1).size() - 1; j++) {
                    temp.add(list.get(i - 1).get(j) + list.get(i - 1).get(j + 1));
                }
                temp.add(1);
                list.add(temp);
            }            
        }

        return list;
    }       
}