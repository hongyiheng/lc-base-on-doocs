class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n = len(s)
        mid, ans = n // 2, 0
        for i in range(n):
            if s[i] in {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}:
                ans += 1 if i + 1 <= mid else -1
        return ans == 0
