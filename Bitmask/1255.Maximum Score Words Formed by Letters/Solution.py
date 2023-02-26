class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        n = len(words)
        ws = [[0] * 26 for _ in range(n)]
        sc = [0] * 26
        for j, w in enumerate(words):
            for c in w:
                ws[j][ord(c) - ord('a')] += 1
                sc[j] += score[ord(c) - ord('a')]
        cnt = [0] * 26
        for c in letters:
            cnt[ord(c) - ord('a')] += 1
        ans = 0
        for i in range(1 << n):
            tmp = cnt[:]
            s = 0
            flag = True
            for j in range(n):
                if i >> j & 1 and flag:
                    s += sc[j]
                    for k in range(26):
                        tmp[k] -= ws[j][k]
                        if tmp[k] < 0:
                            flag = False
                            break
            if flag:
                ans = max(ans, s)
        return ans