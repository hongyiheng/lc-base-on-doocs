class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        cnt = [0] * 32
        for v in nums:
            for i in range(32):
                if v >> i & 1:
                    cnt[i] ^= 1
        ans = 0
        for i in range(32):
            if k >> i & 1 and not cnt[i] or (not k >> i & 1 and cnt[i]):
                ans += 1
        return ans