class ExamRoom {

    TreeSet<Integer> s;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        s = new TreeSet<>();
    }

    public int seat() {
        if (s.size() == 0) {
            s.add(0);
            return 0;
        } else if (s.size() == 1) {
            int x = s.first();
            int ans = x > n - 1 - x ? 0 : n - 1;
            s.add(ans);
            return ans;
        }
        int pre = s.first();
        int d = pre, ans = 0;
        for (int x : s) {
            if (d < (x - pre) / 2) {
                d = (x - pre) / 2;
                ans = (x + pre) / 2;
            }
            pre = x;
        }
        if (d < n - 1 - pre) {
            ans = n - 1;
        }
        s.add(ans);
        return ans;
    }

    public void leave(int p) {
        s.remove(p);
    }
}


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */