class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        ans = tickets[k]
        for i, v in enumerate(tickets):
            if i < k:
                ans += min(tickets[k], v)
            elif i > k:
                ans += min(tickets[k] - 1, v)
        return ans