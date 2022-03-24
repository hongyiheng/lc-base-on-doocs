class Solution {
    int[] tree;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tree = new int[n + 10];
        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> mp = new HashMap<>();
        int index = 1;
        for (int num : temp) {
            if (mp.containsKey(num)) {
                continue;
            }
            mp.put(num, index++);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ans.add(query(mp.get(nums[i]) - 1));
            add(mp.get(nums[i]), 1);
        }
        Collections.reverse(ans);
        return ans;
    }

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
        for (int i = index; i <= tree.length; i += lowbit(i)) {
            tree[i] += incr;
        }
    }
}