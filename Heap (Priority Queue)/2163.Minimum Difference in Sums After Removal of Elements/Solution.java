class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int k = n / 3;

        PriorityQueue<Integer> suffixHeap = new PriorityQueue<>();
        long[] suffixSum = new long[n - k + 1];

        long sufSum = 0;
        for (int i = 2 * k; i < n; i++) {
            suffixHeap.offer(nums[i]);
            sufSum += nums[i];
        }
        suffixSum[n - k] = sufSum;

        for (int i = n - k - 1; i >= k; i--) {
            suffixSum[i] = suffixSum[i + 1];
            if (nums[i] > suffixHeap.peek()) {
                suffixSum[i] = suffixSum[i] - suffixHeap.poll() + nums[i];
                suffixHeap.offer(nums[i]);
            }
        }

        PriorityQueue<Integer> prefixHeap = new PriorityQueue<>((a, b) -> b - a);
        long prefixSum = 0;
        for (int i = 0; i < k; i++) {
            prefixHeap.offer(nums[i]);
            prefixSum += nums[i];
        }

        long ans = prefixSum - suffixSum[k];
        for (int i = k; i < n - k; i++) {
            if (nums[i] < prefixHeap.peek()) {
                prefixSum = prefixSum - prefixHeap.poll() + nums[i];
                prefixHeap.offer(nums[i]);
            }
            ans = Math.min(ans, prefixSum - suffixSum[i + 1]);
        }

        return ans;
    }
}
