class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        cnt = [[] for _ in range(32)]
        for i, v in enumerate(nums):
            for j in range(32):
                if v >> j & 1:
                    cnt[j].append(i)
        ans = []
        n = len(nums)
        for i in range(n):
            t = 1
            for j in range(32):
                if not cnt[j]:
                    continue
                l, r = 0, len(cnt[j]) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if cnt[j][mid] < i:
                        l = mid + 1
                    else:
                        r = mid
                if cnt[j][r] >= i:
                    t = max(t, cnt[j][r] - i + 1)
            ans.append(t)
        return ans
