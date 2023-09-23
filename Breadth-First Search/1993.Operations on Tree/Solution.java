class LockingTree {

    int[] parent;
    Map<Integer, List<Integer>> g;
    int n;
    int[] locks;

    public LockingTree(int[] parent) {
        this.parent = parent;
        g = new HashMap<>();
        n = parent.length;
        locks = new int[n];
        Arrays.fill(locks, -1);
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locks[num] == -1) {
            locks[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (locks[num] != user) {
            return false;
        }
        locks[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locks[num] != -1) {
            return false;
        }
        int p = parent[num];
        while (p != -1) {
            if (locks[p] != -1) {
                return false;
            }
            p = parent[p];
        }
        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(num);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (locks[v] != -1) {
                    locks[v] = -1;
                    cnt++;
                }
                q.add(v);
            }
        }
        if (cnt > 0) {
            locks[num] = user;
        }
        return cnt > 0;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */