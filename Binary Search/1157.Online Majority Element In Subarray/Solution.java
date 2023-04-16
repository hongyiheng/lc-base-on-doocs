class MajorityChecker {

    int[] arr;
    Map<Integer, List<Integer>> g;
    Random random;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        g = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            g.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        random = new Random();
    }

    public int query(int left, int right, int threshold) {
        for (int i = 0; i < (right - left + 1) / threshold + 10; i++) {
            int v = arr[random.nextInt(right - left + 1) + left];
            List<Integer> ids = g.get(v);
            if (ids.size() < threshold) {
                continue;
            }
            int l = queryLeft(ids, left), r = queryRight(ids, right);
            if (r - l + 1 >= threshold) {
                return v;
            }
        }
        return -1;
    }

    public int queryLeft(List<Integer> ids, int left) {
        int l = 0, r = ids.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (ids.get(mid) < left) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int queryRight(List<Integer> ids, int right) {
        int l = 0, r = ids.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (ids.get(mid) <= right) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return ids.get(r) <= right ? r : -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */