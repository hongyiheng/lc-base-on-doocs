class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hs = new HashSet<>(), vs = new HashSet<>();
        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                hs.add(Math.abs(hFences[i] - hFences[j]));
            }
            hs.add(Math.abs(hFences[i] - 1));
            hs.add(Math.abs(hFences[i] - m));
            hs.add(Math.abs(m - 1));
        }
        for (int i = 0; i < vFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                vs.add(Math.abs(vFences[i] - vFences[j]));
            }
            vs.add(Math.abs(vFences[i] - 1));
            vs.add(Math.abs(vFences[i] - n));
            vs.add(Math.abs(n - 1));
        }
        hs.retainAll(vs);
        int ans = -1;
        for (int v : hs) {
            ans = Math.max(ans, v);
        }
        return ans == -1 ? -1 : (int)(1L * ans * ans % ((int)1e9 + 7));
    }
}