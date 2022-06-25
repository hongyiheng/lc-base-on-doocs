class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[2001], cnt2 = new int[2001];
        for (int v : nums1) {
            cnt1[v + 1000]++;
        }
        for (int v : nums2) {
            cnt2[v + 1000]++;
        }
        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (cnt1[i] != 0 && cnt2[i] == 0) {
                diff1.add(i - 1000);
            }
            if (cnt2[i] != 0 && cnt1[i] == 0) {
                diff2.add(i - 1000);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(diff1);
        ans.add(diff2);
        return ans;
    }
}