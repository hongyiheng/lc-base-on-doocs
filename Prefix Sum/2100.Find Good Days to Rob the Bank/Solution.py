class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        n = len(security)
        pre, tail = [0] * n, [0] * n
        for i in range(1, n):
            if security[i] <= security[i - 1]:
                pre[i] = pre[i - 1] + 1
            else:
                pre[i] = 0
        for i in range(n - 2, -1, -1):
            if security[i] <= security[i + 1]:
                tail[i] = tail[i + 1] + 1
            else:
                tail[i] = 0
        ans = []
        for i in range(n):
            if pre[i] >= time and tail[i] >= time:
                ans.append(i)
        return ans