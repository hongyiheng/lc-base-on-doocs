class Solution {
    public int[] threeEqualParts(int[] arr) {
        int cnt = 0, n = arr.length;
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
            }
        }
        if (cnt % 3 != 0) {
            return ans;
        }
        if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        int k = cnt / 3;
        int c = find(n - 1, k, arr);
        int b = find(c - 1, k, arr);
        int a = find(b - 1, k, arr);
        if (a == -1 || b == -1 || c == -1) {
            return ans;
        }
        while (c < n) {
            if (arr[a] != arr[b] || arr[b] != arr[c]) {
                return ans;
            }
            a++;
            b++;
            c++;
        }
        return new int[]{a - 1, b};
    }


    public int find(int end, int k, int[] arr) {
        int cur = 0;
        for (int i = end; i >= 0; i--) {
            cur += arr[i];
            if (cur == k) {
                return i;
            }
        }
        return -1;
    }

}
