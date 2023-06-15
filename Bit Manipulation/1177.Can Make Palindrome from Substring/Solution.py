class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        n = len(s)
        cnt = [0] * (n + 1)
        for i in range(0, n):
            cnt[i + 1] = cnt[i] ^ (1 << (ord(s[i]) - ord('a')))
        ans = []
        for l, r, k in queries:
            mask = cnt[r + 1] ^ cnt[l]
            w = 0
            for i in range(27):
                if 1 << i & mask:
                    w += 1
            ans.append(w // 2 <= k)
        return ans
