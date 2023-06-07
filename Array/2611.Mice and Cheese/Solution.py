class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        n, m = len(reward1), 2010
        gap = [0] * m
        for i in range(n):
            gap[reward1[i] - reward2[i] + 1000] += 1
        for i in range(m - 1, -1, -1):
            if gap[i] > k:
                gap[i] = k
            k -= gap[i]
        ans = 0
        for i in range(n):
            if gap[reward1[i] - reward2[i] + 1000]:
                gap[reward1[i] - reward2[i] + 1000] -= 1
                ans += reward1[i]
            else:
                ans += reward2[i]
        return ans
