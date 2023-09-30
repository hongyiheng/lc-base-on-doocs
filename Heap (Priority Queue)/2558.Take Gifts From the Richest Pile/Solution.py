class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        q = []
        for v in gifts:
            heappush(q, -v)
        for i in range(k):
            v = -heappop(q)
            heappush(q, -int(sqrt(v)))
        return -sum(q)