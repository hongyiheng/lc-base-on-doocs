class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cnt = [0] * 1010
        for v in arr1:
            cnt[v] += 1
        ans = []
        for v in arr2:
            ans += cnt[v] * [v]
            cnt[v] = 0
        for i, v in enumerate(cnt):
            if v:
                ans += [i] * v
        return ans
