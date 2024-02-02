class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        List<int[]> q = new ArrayList<>();
        int n = aliceValues.length;
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, aliceValues[i] + bobValues[i]});
        }
        Collections.sort(q, (a, b) -> b[1] - a[1]);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += aliceValues[q.get(i)[0]];
            } else {
                b += bobValues[q.get(i)[0]];
            }
        }
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : -1;
    }
}