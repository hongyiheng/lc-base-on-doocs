class Solution {
    public int[] replaceElements(int[] arr) {
        int mx = -1;
        for (int i = arr.length - 1; i > -1; i--) {
            int t = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, t);
        }
        return arr;
    }
}