class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        def lower_bound(arr, x):
            l, r = 0, len(arr) - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if arr[mid] <= x:
                    l = mid
                else:
                    r = mid - 1
            return r + 1 if arr[r] <= x else r

        start = sorted([s for s, _ in flowers])
        end = sorted([e for _, e in flowers])
        return [lower_bound(start, v) - lower_bound(end, v - 1) for v in people]