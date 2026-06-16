// using an array
class Solution {
    public int calPoints(String[] operations) {
        int answer = 0, pointer = 0, len = operations.length;
        int[] stack = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (operations[i].equals("C")) {
                pointer -= 1;
            } else if (operations[i].equals("D")) {
                stack[pointer] = 2 * stack[pointer - 1];
                pointer += 1;
            } else if (operations[i].equals("+")) {
                stack[pointer] = stack[pointer - 1] + stack[pointer - 2];
                pointer += 1;
            } else {
                stack[pointer] = Integer.parseInt(operations[i]); 
                pointer += 1;
            }
        }

        for (int i = 0; i < pointer; i++) {
            answer += stack[i];
        }

        return answer;
    }
}