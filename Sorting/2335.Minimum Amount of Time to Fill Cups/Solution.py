class Solution:
    def fillCups(self, amount: List[int]) -> int:
        ans = 0
        while amount[0] and amount[1] and amount[2]:
            amount.sort()
            amount[2] -= 1
            amount[0] -= 1
            ans += 1
        return ans + max(amount)
