class SnapshotArray {

    Map<Integer, List<int[]>> g;
    int ver;

    public SnapshotArray(int length) {
        g = new HashMap<>();
        ver = 0;
    }

    public void set(int index, int val) {
        g.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{ver, val});
    }

    public int snap() {
        return ver++;
    }

    public int get(int index, int snap_id) {
        List<int[]> q = g.getOrDefault(index, new ArrayList<>());
        if (q.isEmpty()) {
            return 0;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (q.get(mid)[0] > snap_id) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return q.get(r)[0] <= snap_id ? q.get(r)[1] : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */