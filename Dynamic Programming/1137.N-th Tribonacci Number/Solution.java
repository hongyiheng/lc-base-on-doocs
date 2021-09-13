class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int one = 0, two = 1, third = 1;
        for (int i = 3; i < n + 1; i++) {
            int temp = third;
            third = temp + two + one;
            one = two;
            two = temp;
        }
        return third;
    }
}