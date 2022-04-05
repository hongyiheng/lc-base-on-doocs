class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        cnt = []
        m = float('inf')
        for i, row in enumerate(mat):
            left, right = 0, len(row)
            while left < right:
                mid = (left + right) >> 1
                if row[mid] == 1:
                    left = mid + 1
                else:
                    right = mid
            heapq.heappush(cnt, [left, i])
        ans = []
        for _ in range(k):
            ans.append(heapq.heappop(cnt)[1])
        return ans