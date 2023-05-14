class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        cnt = Counter(barcodes)
        q = [[-cnt[k], k] for k in cnt.keys()]
        heapq.heapify(q)
        ans = []
        while q:
            a = heapq.heappop(q)
            ans.append(a[1])
            if q:
                b = heapq.heappop(q)
                ans.append(b[1])
                if b[0] + 1:
                    heapq.heappush(q, [b[0] + 1, b[1]])
            if a[0] + 1:
                heapq.heappush(q, [a[0] + 1, a[1]])
        return ans
