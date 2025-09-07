class Solution:
    def sumZero(self, n: int) -> List[int]:
        x = 500
        ans = []
        for i in range(n, 0, -2):
            if i == 1:
                ans.append(0)
            else:
                ans.append(x)
                ans.append(-x)
                x -= 1
        return ans