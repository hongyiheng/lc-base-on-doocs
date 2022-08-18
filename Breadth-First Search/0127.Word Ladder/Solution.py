class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def check_next(a, b):
            diff = 0
            for v1, v2 in zip(a, b):
                if v1 != v2:
                    diff += 1
                if diff > 1:
                    break
            return diff == 1

        n = len(wordList)
        used = [False] * n
        q = deque()
        q.append(beginWord)
        ans = 1
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                for j in range(n):
                    if used[j]:
                        continue
                    ne = wordList[j]
                    if not check_next(cur, ne):
                        continue
                    if ne == endWord:
                        return ans + 1
                    q.append(ne)
                    used[j] = True
            ans += 1
        return 0


