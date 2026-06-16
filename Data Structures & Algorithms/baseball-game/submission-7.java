// using a stack
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (String str : operations) {
            if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (str.equals("+")) {
                int temp = stack.pop();
                int sum = temp + stack.peek();
                stack.add(temp);
                stack.add(sum);
            } else {
                stack.add(Integer.parseInt(str));
            }
        }

        for (int n : stack) {
            answer += n;
        }

        return answer;
    }
}