class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        cnt = Counter(text)
        ans = min(cnt['a'], cnt['b'])
        ans = min(ans, cnt['n'])
        ans = min(ans, cnt['l'] // 2)
        ans = min(ans, cnt['o'] // 2)
        return ans