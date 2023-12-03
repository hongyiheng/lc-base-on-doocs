class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        if n == k:
            return sum(cardPoints)
        l = r = s = total = 0
        mi = inf
        while r < len(cardPoints):
            s += cardPoints[r]
            total += cardPoints[r]
            if r - l + 1 == n - k:
                mi = min(mi, s)
                s -= cardPoints[l]
                l += 1
            r += 1
        return total - mi