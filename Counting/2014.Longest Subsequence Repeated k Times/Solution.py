class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        def check(x):
            i = cnt = 0
            for c in s:
                if c == x[i]:
                    i += 1
                if i == len(x):
                    cnt += 1
                    i = 0
                if cnt >= k:
                    return True
            return False

        cnt = Counter(s)
        cs = [c for c in sorted(cnt.keys()) if cnt[c] >= k]
        q = deque([""])
        ans = ""
        while q:
            x = q.popleft()
            for c in cs:
                nx = x + c
                if check(nx):
                    ans = nx
                    q.append(nx)
        return ans