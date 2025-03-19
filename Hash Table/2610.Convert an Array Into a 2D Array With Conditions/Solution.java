class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] cnt = new int[210];
        for (int v : nums) {
            cnt[v]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        while (n > 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < 210; i++) {
                if (cnt[i] > 0) {
                    row.add(i);
                    cnt[i]--;
                    n--;
                }
            }
            ans.add(row);
        }
        return ans;
    }
}