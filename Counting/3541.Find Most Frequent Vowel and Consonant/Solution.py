class Solution:
    def maxFreqSum(self, s: str) -> int:
        cnt = Counter(list(s))
        a = b = 0
        for k in cnt.keys():
            if k in {'a', 'e', 'i', 'o', 'u'}:
                a = max(a, cnt[k])
            else:
                b = max(b, cnt[k])
        return a + b