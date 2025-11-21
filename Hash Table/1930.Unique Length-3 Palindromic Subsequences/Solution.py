class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        cnt = Counter(list(s))
        pre = defaultdict(int)
        ans = set()
        for v in list(s):
            cnt[v] -= 1
            for i in range(26):
                c = chr(i + ord('a'))
                if cnt[c] and pre[c]:
                    ans.add(c + v + c)
            pre[v] += 1
        return len(ans)
