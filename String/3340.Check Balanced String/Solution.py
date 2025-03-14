class Solution:
    def isBalanced(self, num: str) -> bool:
        ans = 0
        for i, v in enumerate(list(num)):
            if i % 2:
                ans += int(v)
            else:
                ans -= int(v)
        return ans == 0
