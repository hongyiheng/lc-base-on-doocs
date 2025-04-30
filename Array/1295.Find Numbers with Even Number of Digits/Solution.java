class Solution {
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).filter(e -> String.valueOf(e).length() % 2 == 0).count();
    }
}