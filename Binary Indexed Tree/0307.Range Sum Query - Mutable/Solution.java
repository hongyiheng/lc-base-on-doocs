class NumArray {
    int[] tree;
    int[] nums;

    public int lowbit(int x) {
        return x & -x;
    }

    public int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public void add(int index, int incr) {
        for (int i = index; i < tree.length; i += lowbit(i)) {
            tree[i] += incr;
        }
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */