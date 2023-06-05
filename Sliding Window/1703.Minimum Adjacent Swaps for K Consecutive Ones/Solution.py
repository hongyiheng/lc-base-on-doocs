class Solution:
    def minMoves(self, nums: List[int], k: int) -> int:
        pos = []
        for i, v in enumerate(nums):
            if v == 1:
                pos.append(i)
        cur = 0
        for i in range(k):
            cur += (pos[i] - pos[i - 1] - 1) * min(i, k - i)
        ans = cur
        mid = k // 2
        for r in range(k, len(pos)):
            cur -= (pos[r - k + mid] - pos[r - k])
            cur += (pos[r] - pos[r - mid])
            ans = min(ans, cur)
        return ans
