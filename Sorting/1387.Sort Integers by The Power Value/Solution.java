class Solution {

    public int f(int x) {
        int ans = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            ans++;
        }
        return ans;
    }

    public int getKth(int lo, int hi, int k) {
        List<int[]> q = new ArrayList<>();
        for (int i = lo; i < hi + 1; i++) {
            q.add(new int[]{f(i), i});
        }
        q.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return q.get(k - 1)[1];
    }
}