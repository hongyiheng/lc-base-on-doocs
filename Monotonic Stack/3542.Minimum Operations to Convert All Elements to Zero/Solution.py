class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        stk = []
        for v in nums:
            while stk and stk[-1] > v:
                ans += 1
                stk.pop()
            if not stk or stk[-1] != v:
                stk.append(v)
        return ans + len([v for v in stk if v])
