class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        lose_time = [-1] * 100010
        for a, b in matches:
            lose_time[a] = max(lose_time[a], 0)
            lose_time[b] = max(lose_time[b], 0) + 1
        winer, lose_one = [], []
        for i, v in enumerate(lose_time):
            if v == 0:
                winer.append(i)
            if v == 1:
                lose_one.append(i)
        return [winer, lose_one]
