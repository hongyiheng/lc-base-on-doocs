class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = num > 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        String ans = sb.reverse().toString();
        return flag ? ans : "-" + ans;
    }
}