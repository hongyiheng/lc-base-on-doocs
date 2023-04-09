class Solution:
    def checkDistances(self, s: str, distance: List[int]) -> bool:
        ids = [-1] * 26
        for i, c in enumerate(s):
            id = ord(c) - ord('a')
            if ids[id] == -1:
                ids[id] = i
            else:
                gap = i - ids[id] - 1
                if distance[id] != gap:
                    return False
        return True