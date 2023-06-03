class Solution:
    def maxRepOpt1(self, text: str) -> int:
        cnt = Counter(text)
        ans = 0
        i, n = 0, len(text)
        while i < n:
            j = i + 1
            while j < n and text[j] == text[i]:
                j += 1
            k = j + 1
            while k < n and text[k] == text[i]:
                k += 1
            ans = max(ans, min(j - i + k - j, cnt[text[i]]))
            i = j
        return ans