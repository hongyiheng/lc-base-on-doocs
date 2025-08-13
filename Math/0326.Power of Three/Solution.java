class Solution {
    public boolean isPowerOfThree(int n) {
      if (n <= 0) {
        return false;
      }
      return Math.pow(3, 20) % n == 0;
    }
}