class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        c_cnt = [0] * 4
        for c in suits:
            c_cnt[ord(c) - ord('a')] += 1
            if c_cnt[ord(c) - ord('a')] == 5:
                return "Flush"
        v_cnt = [0] * 14
        for v in ranks:
            v_cnt[v] += 1
        mx = max(v_cnt)
        if mx >= 3:
            return "Three of a Kind"
        if mx == 2:
            return "Pair"
        return "High Card"
