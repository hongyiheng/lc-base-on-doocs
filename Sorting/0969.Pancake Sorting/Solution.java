class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int[] tmp = new int[n + 1];
        while (n > 1) {
            int index = getIndex(arr, n--);
            reverse(arr, index, tmp);
            reverse(arr, n, tmp);
            ans.add(index + 1);
            ans.add(n + 1);
        }
        return ans;
    }

    public int getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void reverse(int[] arr, int right, int[] tmp) {
        int tmpIndex = -1;
        for (int i = right; i >= 0; i--) {
            tmp[++tmpIndex] = arr[i];
        }
        while (tmpIndex >= 0) {
            arr[tmpIndex] = tmp[tmpIndex--];
        }
    }
}