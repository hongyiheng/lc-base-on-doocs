class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int s = 0;
        for (int v : apple) {
            s += v;
        }
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i > -1; i--) {
            s -= capacity[i];
            if (s <= 0) {
                return capacity.length - i;
            }
        }
        return -1;
    }
}