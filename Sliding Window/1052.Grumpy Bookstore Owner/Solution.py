class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        pre = [0] * (n + 1)
        basic = 0
        for i in range(1, n + 1):
            pre[i] = pre[i - 1]
            if grumpy[i - 1] == 1:
                pre[i] += customers[i - 1]
            else:
                basic += customers[i - 1]
        res = 0
        for i in range(n + 1):
            right = i + minutes if i + minutes < n else n
            res = max(res, basic + pre[right] - pre[i])
        return res
