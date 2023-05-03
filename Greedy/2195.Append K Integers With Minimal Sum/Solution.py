class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        ans = (1 + k) * k / 2
        s = {v for v in nums}
        cur = k
        for v in s:
            if v <= k:
                cur += 1
                while cur in s:
                    cur += 1
                ans = ans - v + cur
        return int(ans)