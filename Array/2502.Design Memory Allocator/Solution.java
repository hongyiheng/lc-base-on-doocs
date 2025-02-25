class Allocator {

    int[] q;

    public Allocator(int n) {
        q = new int[n];
    }

    public int allocate(int size, int mID) {
        int cnt = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == size) {
                for (int j = i - size + 1; j <= i; j++) {
                    q[j] = mID;
                }
                return i - size + 1;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int ans = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == mID) {
                q[i] = 0;
                ans++;
            }
        }
        return ans;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */