class Solution {
    int[] p;
    int kill;

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        this.kill = kill;
        p = new int[50010];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(pid.get(i), ppid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        for (int id : pid) {
            if (find(id) == kill) {
                ans.add(id);
            }
        }
        return ans;
    }

    private int find(int x) {
        if (x == kill) {
            return x;
        }
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1), r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }
}