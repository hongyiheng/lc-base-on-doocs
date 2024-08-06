class Solution:
    def maxmiumScore(self, cards: List[int], cnt: int) -> int:
        cards.sort(reverse=True)
        ans = 0
        odd = even = inf
        for v in cards:
            if cnt:
                if v % 2 == 0:
                    even = v
                else:
                    odd = v
                ans += v
                cnt -= 1
            elif ans % 2:
                if v % 2 == 0 and (ans - odd + v) % 2 == 0:
                    ans = ans - odd + v
                elif v % 2 == 1 and (ans - even + v) % 2 == 0:
                    ans = ans - even + v
        return ans if ans % 2 == 0 else 0