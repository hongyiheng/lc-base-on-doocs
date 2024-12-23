class ExamRoom {

    TreeSet<Integer> q;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        q = new TreeSet<>();
    }

    public int seat() {
        if (q.size() == 0) {
            q.add(0);
            return 0;
        }
        int last = q.first();
        int d = last, ans = 0;
        for (int v : q) {
            int nd = (v - last) / 2;
            if (d < nd) {
                ans = (v + last) / 2;
                d = nd;
            }
            last = v;
        }
        if (d < n - 1 - last) {
            ans = n - 1;
        }
        q.add(ans);
        return ans;
    }

    public void leave(int p) {
        q.remove(p);
    }
}


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */