class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        def cmp(a, b):
            nonlocal n
            i, j = ord(a) - ord('A'), ord(b) - ord('A')
            for k in range(n):
                if cnt[i][k] != cnt[j][k]:
                    return cnt[j][k] - cnt[i][k]
            return i - j

        n = len(votes[0])
        cnt = [[0] * n for _ in range(26)]
        for v in votes:
            for i, c in enumerate(v):
                cnt[ord(c) - ord('A')][i] += 1
        return "".join(sorted(votes[0], key=cmp_to_key(cmp)))


