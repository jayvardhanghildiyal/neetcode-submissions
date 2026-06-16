class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            // adding element to list
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 0);
            }
            map.replace(s.charAt(right), map.get(s.charAt(right)) + 1);
            

            // get the maximum frequency element
            int num = 0;
            for (Character ele : map.keySet()) {
                if (num < map.get(ele)) {
                    num = map.get(ele);
                }            
            }
            
            while (right - left + 1 - num > k) {
                map.replace(s.charAt(left), map.get(s.charAt(left)) - 1);
                left += 1;
            } 

            count = Math.max(count, right - left + 1);
            right += 1;
        }

        return count;
    } 
}
