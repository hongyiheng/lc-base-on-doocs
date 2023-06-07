class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            q.add(new int[]{reward1[i] - reward2[i], i});
        }
        q.sort((a, b) -> b[0] - a[0]);
        Set<Integer> pos = q.stream().map(e -> e[1]).limit(k).collect(Collectors.toSet());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (pos.contains(i)) {
                ans += reward1[i];
            } else {
                ans += reward2[i];
            }
        }
        return ans;
    }
}
