class Solution:
    def centeredSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            vis = set()
            s = 0
            for j in range(i, n):
                vis.add(nums[j])
                s += nums[j]
                if s in vis:
                    ans += 1
        return ans