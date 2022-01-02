class Solution {
    List<Integer> nums;
    List<List<Integer>> res;
    Deque<Integer> path;

    public List<List<Integer>> getFactors(int n) {
        nums = new ArrayList();
        res = new ArrayList();
        path = new ArrayDeque();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                nums.add(i);
            }
        }
        if (!nums.isEmpty()) {
            backTrace(n, 0);
        }
        return res;
    }

    public void backTrace(int n, int index) {
        if (n == 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (n % nums.get(i) == 0) {
                path.addLast(nums.get(i));
                backTrace(n / nums.get(i), i);
                path.removeLast();
            }
        }
    }
}