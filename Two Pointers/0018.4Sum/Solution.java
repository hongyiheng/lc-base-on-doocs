class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> use = new HashSet<>();
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                long t = (long)target - nums[a] - nums[b];
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long v = nums[c] + nums[d];
                    if (v < t) {
                        c++;
                    } else if (v > t) {
                        d--;
                    } else {
                        List<Integer> arr = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (int k : new int[]{nums[a], nums[b], nums[c], nums[d]}) {
                            arr.add(k);
                            sb.append(k + ",");
                        }
                        if (!use.contains(sb.toString())) {
                            ans.add(arr);
                            use.add(sb.toString());
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}