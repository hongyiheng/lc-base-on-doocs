class Solution:
    def mergeSimilarItems(self, items1: List[List[int]], items2: List[List[int]]) -> List[List[int]]:
        cnt = [0] * 1010
        for v, w in items1:
            cnt[v] += w
        for v, w in items2:
            cnt[v] += w
        ans = []
        for v, w in enumerate(cnt):
            if w:
                ans.append([v, w])
        return ans
