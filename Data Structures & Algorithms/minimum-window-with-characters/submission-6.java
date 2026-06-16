class Solution {
    public String minWindow(String s, String t) {
         if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // put all the elements of t inside the hashmap
        for (Character ele : t.toCharArray()) {
            if (!map.containsKey(ele)) {
                map.put(ele, 0);
            }
            map.replace(ele, map.get(ele) + 1);
        }

        HashMap<Character, Integer> sub = new HashMap<>();

        for (Character ele : map.keySet()) {
            sub.put(ele, 0);
        }

        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int[] index = {-1, -1};

        int have = 0;
        int need = sub.size();

        while (right < s.length()) {

            if (sub.containsKey(s.charAt(right))) {

                sub.replace(s.charAt(right), sub.get(s.charAt(right)) + 1);

                if (map.containsKey(s.charAt(right)) && sub.get(s.charAt(right)).equals(map.get(s.charAt(right)))) {
                    have += 1;
                }

                while (have == need) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        index[0] = left;
                        index[1] = right;
                    }

                    if (sub.containsKey(s.charAt(left))) {
                        if (sub.get(s.charAt(left)) > map.get(s.charAt(left))) {
                            sub.replace(s.charAt(left), sub.get(s.charAt(left)) - 1);
                        } else if (sub.get(s.charAt(left)).equals(map.get(s.charAt(left)))) {
                            sub.replace(s.charAt(left), sub.get(s.charAt(left)) - 1);
                            have -= 1;
                        }
                    }

                    left += 1;
                }
            }

            right += 1;
        }

        if (len == Integer.MAX_VALUE) {
            //System.out.println("we have returned an empty string");
            return "";
        } else {
            return s.substring(index[0], index[1] + 1);
        }
    }
}
