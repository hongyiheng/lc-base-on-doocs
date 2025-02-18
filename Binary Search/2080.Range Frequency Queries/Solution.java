class RangeFreqQuery {

    Map<Integer, List<Integer>> g = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            g.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int search(List<Integer> q, int t) {
        int l = 0, r = q.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public int query(int left, int right, int value) {
        List<Integer> q = g.get(value);
        if (q == null) {
            return 0;
        }
        int l = search(q, left);
        int r = search(q, right + 1);
        return r - l;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */