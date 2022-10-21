class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        s = dict()
        for v in nums:
            s[v] = s.get(v, 0) + 1
        ans = 0
        for v in s:
            if k != 0 and v + k in nums:
                ans += 1
            if k == 0 and s[v] > 1:
                ans += 1
        return ans
