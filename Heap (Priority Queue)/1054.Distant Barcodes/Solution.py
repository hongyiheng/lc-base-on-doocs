class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        m = 100010
        cnt = [0] * m
        for v in barcodes:
            cnt[v] += 1
        q = []
        for i, v in enumerate(cnt):
            if v:
                heapq.heappush(q, [-v, i])
        i = 0
        while q:
            v, x = heapq.heappop(q)
            barcodes[i] = x
            i += 1
            if q:
                nv, nx = heapq.heappop(q)
                barcodes[i] = nx
                i += 1
                if nv + 1 != 0:
                    heapq.heappush(q, [nv + 1, nx])
            if v + 1 != 0:
                heapq.heappush(q, [v + 1, x])
        return barcodes
