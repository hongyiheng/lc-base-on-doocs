class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        n, m = len(name), len(typed)
        if n > m:
            return False
        i = j = 0
        while j < m:
            if i < n and name[i] == typed[j]:
                i += 1
                j += 1
            elif j > 0 and typed[j] == typed[j - 1]:
                j += 1
            else:
                return False
        return i == n and j == m