class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> container = new ArrayList<Integer>();

        for (String str : tokens) {
            if ("+-*/".contains(str)) {
                int num2 = container.get(container.size() - 1);
                container.remove(container.size() - 1);

                int num1 = container.get(container.size() - 1);
                container.remove(container.size() - 1);

                switch (str) {
                    case "+" : container.add(num1 + num2);
                        break;
                    case "-" : container.add(num1 - num2);
                        break;
                    case "*" : container.add(num1 * num2);
                        break;
                    case "/" : container.add(num1 / num2);
                        break;
                }
            } else  {
                container.add(Integer.valueOf(str));
            }
        }

        return container.get(0);
    }
}
