class Solution {
    Set<Integer> set = new HashSet<>();
    int m, n;
    Random r = new Random();

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int i = r.nextInt(m * n);
        while (set.contains(i)) {
           i = r.nextInt(m * n);
        }
        set.add(i);
        return new int[]{i / n, i % n};
    }

    public void reset() {
        set.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */