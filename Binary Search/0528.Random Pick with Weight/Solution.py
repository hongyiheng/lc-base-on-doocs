import random
class Solution:
    def __init__(self, w: List[int]):
        n = len(w)
        self.pre = [0] * (n + 1)
        for i in range(n):
            self.pre[i + 1] = self.pre[i] + w[i]

    def pickIndex(self) -> int:
        n = len(self.pre)
        t = random.randrange(1, self.pre[n - 1] + 1)
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) >> 1
            if self.pre[mid] >= t:
                right = mid
            else:
                left = mid + 1
        return right - 1




# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()