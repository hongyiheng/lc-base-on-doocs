class FindSumPairs {

    int[] nums2;
    Map<Integer, Integer> cnt1, cnt2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        cnt1 = new HashMap<>();
        cnt2 = new HashMap<>();
        for (int v : nums1) {
            cnt1.put(v, cnt1.getOrDefault(v, 0) + 1);
        }
        for (int v : nums2) {
            cnt2.put(v, cnt2.getOrDefault(v, 0) + 1);
        }
    }

    public void add(int index, int val) {
        cnt2.put(nums2[index], cnt2.get(nums2[index]) - 1);
        nums2[index] += val;
        cnt2.put(nums2[index], cnt2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
            if (entry.getKey() > tot) {
                continue;
            }
            int k = entry.getKey(), cnt = entry.getValue();
            ans += cnt * cnt2.getOrDefault(tot - k, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */