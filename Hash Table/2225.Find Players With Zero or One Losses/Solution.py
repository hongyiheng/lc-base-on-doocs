class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        to = dict()
        for w, l in matches:
            to[l] = to.get(l, 0) + 1
            to[w] = to.get(w, 0)
        win, lose_one = [], []
        for k in to.keys():
            if to[k] == 0:
                win.append(k)
            elif to[k] == 1:
                lose_one.append(k)
        win.sort()
        lose_one.sort()
        return [win, lose_one]