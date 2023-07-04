class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        @cache
        def dfs(i, pre):
            if i == n:
                return 0
            res = dfs(i + 1, arr1[i]) if arr1[i] > pre else inf
            l, r = 0, m - 1
            while l < r:
                mid = (l + r) >> 1
                if arr2[mid] <= pre:
                    l = mid + 1
                else:
                    r = mid
            if l < m and arr2[l] > pre:
                res = min(res, dfs(i + 1, arr2[l]) + 1)
            return res

        n, m = len(arr1), len(arr2)
        arr2.sort()
        res = dfs(0, -1)
        return -1 if res == inf else res