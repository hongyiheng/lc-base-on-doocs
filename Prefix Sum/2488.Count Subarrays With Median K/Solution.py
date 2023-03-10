class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n, pos, s = len(nums), nums.index(k), 0
        cnt = dict()
        cnt[0] = 1
        for i in range(pos + 1, n):
            s += 1 if nums[i] > k else -1
            cnt[s] = cnt.get(s, 0) + 1
        ans = cnt.get(0, 0) + cnt.get(1, 0)
        s = 0
        for i in range(pos - 1, -1, -1):
            s += 1 if nums[i] > k else -1
            ans += cnt.get(-s, 0)
            ans += cnt.get(-s + 1, 0)
        return ans
