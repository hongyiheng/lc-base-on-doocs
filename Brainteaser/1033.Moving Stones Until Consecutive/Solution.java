class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int gap1 = arr[1] - arr[0] - 1, gap2 = arr[2] - arr[1] - 1;
        if (gap1 == 0 && gap2 == 0) {
            return new int[]{0, 0};
        }
        return new int[]{gap1 > 1 && gap2 > 1 ? 2 : 1, gap1 + gap2};
    }
}
