class Solution {

    int n, m;
    int[] arr1, arr2;
    Map<String, Integer> f;

    public int dfs(int i, int pre) {
        if (i == n) {
            return 0;
        }
        String key = i + "_" + pre;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int res = arr1[i] > pre ? dfs(i + 1, arr1[i]) : 0x3f3f3f3f;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr2[mid] <= pre) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (arr2[l] > pre) {
            res = Math.min(res, dfs(i + 1, arr2[l]) + 1);
        }
        f.put(key, res);
        return res;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        n = arr1.length;
        m = arr2.length;
        this.arr1 = arr1;
        this.arr2 = arr2;
        f = new HashMap<>();
        Arrays.sort(arr2);
        int res = dfs(0, -1);
        return res == 0x3f3f3f3f ? -1 : res;
    }
}