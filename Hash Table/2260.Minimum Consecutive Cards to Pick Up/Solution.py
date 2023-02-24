class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        n = len(cards)
        ans = n + 1
        mp = dict()
        for i, v in enumerate(cards):
            if v in mp:
                ans = min(ans, i - mp[v] + 1)
            mp[v] = i
        return -1 if ans == n + 1 else ans
