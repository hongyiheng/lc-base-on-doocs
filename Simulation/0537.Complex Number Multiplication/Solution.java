class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.split("\\+")[0]);
        int n1 = num1.split("\\+")[1].length();
        int a2 = Integer.parseInt(num1.split("\\+")[1].substring(0, n1 - 1));
        int b1 = Integer.parseInt(num2.split("\\+")[0]);
        int n2 = num2.split("\\+")[1].length();
        int b2 = Integer.parseInt(num2.split("\\+")[1].substring(0, n2 - 1));
        int first = a1 * b1 - a2 * b2;
        int second = a1 * b2 + b1 * a2;
        return first + "+" + second + "i";
    }
}