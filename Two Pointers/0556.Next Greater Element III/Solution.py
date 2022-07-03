class Solution:
    def nextGreaterElement(self, n: int) -> int:
        def swap(s, i, j):
            s[i], s[j] = s[j], s[i]

        def reverse(s, i):
            l, r = i, len(s) - 1
            while l < r:
                swap(s, l, r)
                l += 1
                r -= 1

        s = list(str(n))
        m = len(s)
        i = m - 2
        while i >= 0:
            if s[i] < s[i + 1]:
                break
            i -= 1
        if i < 0:
            return -1
        j = m - 1
        while j >= 0:
            if s[i] < s[j]:
                break
            j -= 1
        if j < 0:
            return -1
        swap(s, i, j)
        reverse(s, i + 1)
        ans = int("".join(s))
        return -1 if ans >= 2 ** 31 else ans