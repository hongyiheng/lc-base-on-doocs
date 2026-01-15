class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        def f(arr):
            if not arr:
                return 1
            arr.sort()
            ans = cur = 1
            for i in range(1, len(arr)):
                if arr[i] == arr[i - 1] + 1:
                    cur += 1
                else:
                    cur = 1
                ans = max(ans, cur)
            return ans + 1

        h_max = f(hBars)
        v_max = f(vBars)
        return min(h_max, v_max) ** 2