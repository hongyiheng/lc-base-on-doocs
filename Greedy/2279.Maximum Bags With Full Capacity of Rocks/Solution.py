class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        q = [c - r for c, r in zip(capacity, rocks)]
        q.sort()
        ans = 0
        for v in q:
            if additionalRocks < v:
                break
            additionalRocks -= v
            ans += 1
        return ans