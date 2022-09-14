class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int val = 0, cnt = 0;
        for (int i = (int)(n * 0.05); i < (int)(n * 0.95); i++) {
            val += arr[i];
            cnt ++;
        }
        return val * 1.0 / cnt * 1.0;
    }
}