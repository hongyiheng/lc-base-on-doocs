class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        tmp = sorted(set(arr))
        mp = {}
        for i, v in enumerate(tmp, 1):
            mp[v] = i
        return [mp[v] for v in arr]