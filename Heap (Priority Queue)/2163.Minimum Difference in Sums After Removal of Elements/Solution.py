class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        n = len(nums)
        k = n // 3

        suffix = [nums[i] for i in range(2 * k, n)]
        heapq.heapify(suffix)
        suf_s = [0] * (n - k + 1)
        suf_s[-1] = sum(suffix)
        for i in range(n - k - 1, k - 1, -1):
            suf_s[i] = suf_s[i + 1]
            if nums[i] > suffix[0]:
                suf_s[i] = suf_s[i] - heapq.heappop(suffix) + nums[i]
                heapq.heappush(suffix, nums[i])

        pre = [-nums[i] for i in range(k)]
        heapq.heapify(pre)
        pre_s = -sum(pre)
        ans = pre_s - suf_s[k]
        for i in range(k, n - k):
            if nums[i] < -pre[0]:
                pre_s = pre_s + heapq.heappop(pre) + nums[i]
                heapq.heappush(pre, -nums[i])
            ans = min(ans, pre_s - suf_s[i + 1])
        return ans