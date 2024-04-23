class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        l = r = 0
        resL = mx = cur = 0
        while r < n:
            if r - l + 1 > minutes:
                if grumpy[l]:
                    cur -= customers[l]
                l += 1
            if grumpy[r]:
                cur += customers[r]
            if cur > mx:
                resL = l
                mx = cur
            r += 1
        ans = 0
        for i in range(n):
            if resL <= i <= resL + minutes - 1 or not grumpy[i]:
                ans += customers[i]
        return ans