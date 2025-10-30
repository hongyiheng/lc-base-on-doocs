class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        n, ans = len(target), 0
        for i in range(n - 1):
            if target[i] > target[i + 1]:
                ans += (target[i] - target[i + 1])
        ans += target[n - 1]
        return ans