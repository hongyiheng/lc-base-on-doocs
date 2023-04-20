class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        m, n = len(firstList), len(secondList)
        i = j = 0
        ans = []
        while i < m and j < n:
            a, b = firstList[i]
            c, d = secondList[j]
            l, r = max(a, c), min(b, d)
            if r >= l:
                ans.append([l, r])
            if b < d:
                i += 1
            else:
                j += 1
        return ans
