class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        n = len(dominoes)
        q = deque([[i, v] for i, v in enumerate(dominoes) if v != '.'])
        ans = list(dominoes)
        while q:
            for _ in range(len(q)):
                pos, c = q.popleft()
                if c == 'L' and pos > 0 and dominoes[pos - 1] == '.':
                    if pos > 1 and dominoes[pos - 2] == 'R':
                        continue
                    ans[pos - 1] = 'L'
                    q.append([pos - 1, 'L'])
                if c == 'R' and pos < n - 1 and dominoes[pos + 1] == '.':
                    if pos + 2 < n and dominoes[pos + 2] == 'L':
                        continue
                    ans[pos + 1] = 'R'
                    q.append([pos + 1, 'R'])   
            dominoes = "".join(ans)
        return "".join(ans)