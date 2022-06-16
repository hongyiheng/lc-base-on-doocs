from sortedcontainers import SortedList

class Solution:
    def halveArray(self, nums: List[int]) -> int:
        s = 0
        q = SortedList()
        for v in nums:
            s += v
            q.add(v)
        target, ans = s / 2, 0
        while s > target:
            cur = q.pop()
            s -= cur / 2
            q.add(cur / 2)
            ans += 1
        return ans