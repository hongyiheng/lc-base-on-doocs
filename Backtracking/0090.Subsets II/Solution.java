class Solution {

    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return ans;
    }

    public void dfs(int i, Deque<Integer> path) {
        if (i >= nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        path.addLast(nums[i]);
        dfs(i + 1, path);
        path.pollLast();
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }
        dfs(i + 1, path);
    }
}