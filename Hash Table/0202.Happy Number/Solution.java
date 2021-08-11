class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> allNum = new HashSet<>();
        while (n != 1) {
            n = square(n);
            if (allNum.contains(n)) {
                return false;
            }
            allNum.add(n);
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