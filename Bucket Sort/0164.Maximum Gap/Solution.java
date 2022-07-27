class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int v : nums) {
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        int bucketLen = Math.max(1, (max - min) / (n - 1));
        List<Integer>[] bucket = new ArrayList[(max - min) / bucketLen + 1];
        for (int v : nums) {
            if (bucket[(v - min) / bucketLen] == null) {
                bucket[(v - min) / bucketLen] = new ArrayList<>();
            }
            bucket[(v - min) / bucketLen].add(v);
        }
        int ans = 0, last = Integer.MAX_VALUE;
        for (List<Integer> b : bucket) {
            if (b == null) {
                continue;
            }
            int bMax = Integer.MIN_VALUE, bMin = Integer.MAX_VALUE;
            for (int v : b) {
                bMax = Math.max(bMax, v);
                bMin = Math.min(bMin, v);
            }
            ans = Math.max(ans, bMax - bMin);
            if (last != Integer.MAX_VALUE) {
                ans = Math.max(ans, bMin - last);
            }
            last = bMax;
        }
        return ans;
    }
}