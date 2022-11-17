class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        ws = [deque() for _ in range(26)]
        for w in words:
            ws[ord(w[0]) - ord('a')].append(w)
        ans = 0
        for c in s:
            q = ws[ord(c) - ord('a')]
            for _ in range(len(q)):
                v = q.popleft()
                if len(v) == 1:
                    ans += 1
                else:
                    ws[ord(v[1]) - ord('a')].append(v[1:])
        return ans
