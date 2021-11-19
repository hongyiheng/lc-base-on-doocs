class Solution {
    public int findSpecialInteger(int[] arr) {
        int limit = arr.length >> 2;
        int cur = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (cur == arr[i]) {
                limit--;
            } else {
                limit = (arr.length >> 2) - 1;
                cur = arr[i];
            }
            if (limit < 0) {
                return arr[i];
            }
        }
        return -1;
    }
}