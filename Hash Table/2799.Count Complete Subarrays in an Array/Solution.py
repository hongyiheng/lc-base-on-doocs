class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        t = len(set(nums))
        cnt = defaultdict(int)
        l = ans = 0
        n = len(nums)
        for r, v in enumerate(nums):
            cnt[v] += 1
            while len(cnt.keys()) == t:
                ans += n - r
                cnt[nums[l]] -= 1
                if cnt[nums[l]] == 0:
                    cnt.pop(nums[l])
                l += 1
        return ans
        