class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        ans, n = 0, len(edges)
        score = [0] * n
        for i, v in enumerate(edges):
            score[v] += i
            if (score[v] > score[ans]) or (score[v] == score[ans] and v < ans):
                ans = v
        return ans