class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        nums.sort()
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        ans = []
        for t in queries:
            l, r = 0, n - 1
            while l < r:
                mid = (l + r) >> 1
                if nums[mid] < t:
                    l = mid + 1
                else:
                    r = mid
            k = l if nums[l] >= t else l + 1
            ans.append(t * k - pre[k] + pre[n] - pre[k] - t * (n - k))
        return ans