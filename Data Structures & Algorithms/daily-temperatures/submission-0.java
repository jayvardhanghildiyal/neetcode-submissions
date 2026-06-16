class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    arr[i] = j - i;
                    break;
                } else if (j == temperatures.length - 1) {
                     arr[j] = 0;
                 }
            }
        }

        

        return arr;
    }

}
