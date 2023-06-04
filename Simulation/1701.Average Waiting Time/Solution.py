class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        cnt = cur = 0
        for a, t in customers:
            cur = max(cur, a) + t
            cnt += cur - a
        return cnt / len(customers)