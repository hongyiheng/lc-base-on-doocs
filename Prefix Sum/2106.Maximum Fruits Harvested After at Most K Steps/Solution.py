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

        ans = 0
        for l in range(startPos - k, startPos + 1):
            if l > n:
                break
            r = max(startPos, startPos + k - (startPos - l) * 2)
            ans = max(ans, pre[min(r, n) + 1] - pre[min(max(0, l), n)])
            r = max(startPos, (l + startPos + k) // 2)
            ans = max(ans, pre[min(r, n) + 1] - pre[min(max(0, l), n)])
        return ans
