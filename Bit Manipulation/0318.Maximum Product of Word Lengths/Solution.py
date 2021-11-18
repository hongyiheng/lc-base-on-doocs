class Solution:
    def maxProduct(self, words: List[str]) -> int:
        n, index = len(words), 0
        sim = [0] * n
        for w in words:
            t = 0
            for i in range(len(w)):
                u = ord(w[i]) - ord('a')
                t |= (1 << u)
            sim[index] = t
            index += 1
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                if sim[i] & sim[j] == 0:
                    ans = max(ans, len(words[i]) * len(words[j]))
        return ans