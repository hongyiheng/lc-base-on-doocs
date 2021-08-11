class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = square(n);
        while (fast != 1) {
            if (slow == fast) {
                return false;
            }
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);
        }
        return true;
    }

    public int square(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}