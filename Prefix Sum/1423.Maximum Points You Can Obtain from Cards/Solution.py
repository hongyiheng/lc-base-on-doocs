class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        pre = [0] * (n + 1)
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + cardPoints[i - 1]
        w, m = n - k, float("inf")
        for l in range(n - w + 1):
            r = l + w
            m = min(m, pre[r] - pre[l])
        return pre[n] - m