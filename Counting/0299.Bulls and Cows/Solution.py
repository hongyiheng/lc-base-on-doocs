class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        cnt = [0] * 10
        for c in secret:
            cnt[int(c)] += 1
        ans = [0, 0]
        for c in guess:
            idx = int(c)
            if cnt[idx]:
                ans[1] += 1
                cnt[idx] -= 1
        for a, b in zip(secret, guess):
            if a == b:
                ans[0] += 1
                ans[1] -= 1
        return str(ans[0]) + 'A' + str(ans[1]) + 'B'
