class Node {
    int l;
    int r;
    int v;
}

class Segment {
    Node[] tr;
    int idx;
    int[] nums;

    public Segment(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        tr = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tr[i] = new Node();
        }
        idx = 0;
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].v = nums[idx++];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushUp(u);
    }

    public void pushUp(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int ans = 0;
        if (l <= mid) {
            ans += query(u << 1, l, r);
        }
        if (r > mid) {
            ans += query(u << 1 | 1, l, r);
        }
        return ans;
    }

    public void modify(int u, int x, int incr) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v += incr;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, incr);
        } else {
            modify(u << 1 | 1, x, incr);
        }
        pushUp(u);
    }
}


class NumArray {
    Segment tree;
    int[] nums;

    public NumArray(int[] nums) {
        tree = new Segment(nums);
        this.nums = nums;
    }

    public void update(int index, int val) {
        tree.modify(1, index + 1, val - tree.query(1, index + 1, index + 1));
    }

    public int sumRange(int left, int right) {
        return tree.query(1, left + 1, right + 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */