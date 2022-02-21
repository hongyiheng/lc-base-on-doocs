class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        n = len(dominoes)
        q = deque()
        ans = []
        for i, v in enumerate(dominoes):
            ans.append(v)
            if v == 'L' or v == 'R':
                q.append(i)
        while q:
            m = len(q)
            for _ in range(m):
                i = q.popleft()
                cur = dominoes[i]
                if cur == "L" and i > 0 and dominoes[i - 1] == ".":
                    if i > 1 and dominoes[i - 2] == "R":
                        continue
                    ans[i - 1] = "L"
                    q.append(i - 1)
                if cur == "R" and i < n - 1 and dominoes[i + 1] == ".":
                    if i < n - 2 and dominoes[i + 2] == "L":
                        continue
                    ans[i + 1] = "R"
                    q.append(i + 1)
            dominoes = "".join(ans)
        return "".join(ans)