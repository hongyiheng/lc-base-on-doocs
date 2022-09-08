class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        ans = [0] * n
        l, r, idx = 1, n, 0
        while idx < k:
            if idx % 2 == 0:
                ans[idx] = l
                l += 1
            else:
                ans[idx] = r
                r -= 1
            idx += 1
        while idx < n:
            if k % 2 == 0:
                ans[idx] = r
                r -= 1
            else:
                ans[idx] = l
                l += 1
            idx += 1
        return ans