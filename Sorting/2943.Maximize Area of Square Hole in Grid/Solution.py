class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        def get_mx(arr):
            arr.sort()
            ans, cur, cnt = 0, 1, 0
            for v in arr:
                if v == cur + 1:
                    cnt += 1
                else:
                    cnt = 1
                ans = max(ans, cnt + 1)
                cur = v
            return ans

        return min(get_mx(hBars), get_mx(vBars)) ** 2