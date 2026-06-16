class Solution {

    public String encode(List<String> strs) {
        int stringSize = 0;

        String answer = "";

        for (String str : strs) {
            answer += String.valueOf(str.length()) + "#" + str;
        }

        return answer;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();

        int i = 0;

        while (i < str.length()) {
            String tings = "";
            while (str.charAt(i) != '#') {
                tings += str.charAt(i);
                i += 1;
            }

            i += 1;

            int number = Integer.valueOf(tings);
            list.add(str.substring(i, i + number));
            i += number;
        }

        return list;
    }
}
