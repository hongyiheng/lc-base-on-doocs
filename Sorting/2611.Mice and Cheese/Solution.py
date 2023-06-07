class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        n = len(reward1)
        gap = []
        for i in range(n):
            gap.append((reward1[i] - reward2[i], i))
        gap.sort(reverse=True)
        pos = {gap[i][1] for i in range(k)}
        ans = 0
        for i in range(n):
            if i in pos:
                ans += reward1[i]
            else:
                ans += reward2[i]
        return ans
