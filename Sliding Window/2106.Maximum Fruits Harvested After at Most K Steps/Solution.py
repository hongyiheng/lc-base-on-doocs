class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        n, m = fruits[-1][0], len(fruits)
        pre = [0] * (n + 2)
        j = 0
        for i in range(n + 1):
            pre[i + 1] = pre[i]
            if j < m and fruits[j][0] == i:
                pre[i + 1] += fruits[j][1]
                j += 1

        if k == 0:
            return pre[startPos + 1] - pre[startPos] if 0 <= startPos <= n else 0

        l = startPos - k
        ans = 0
        while l <= startPos and l <= n:
            r = max(startPos, startPos + k - (startPos - l) * 2)
            ans = max(ans, pre[min(r, n) + 1] - pre[min(max(0, l), n)])
            l += 1

        r = startPos + k
        while r >= startPos:
            l = min(startPos, startPos - k + (r - startPos) * 2)
            if l > n:
                break
            ans = max(ans, pre[min(r, n) + 1] - pre[min(max(0, l), n)])
            r -= 1

        return ans
