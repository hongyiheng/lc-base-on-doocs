class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        ans = [0]
        if n == 1:
            return ans
        step = [0] * n
        mp = defaultdict(list)
        for e in edges:
            mp[e[0]].append(e[1])
            mp[e[1]].append(e[0])
            step[e[0]] += 1
            step[e[1]] += 1
        q = deque()
        for i, v in enumerate(step):
            if v == 1:
                q.append(i)
        while q:
            ans.clear()
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                ans.append(cur)
                ne = mp[cur]
                for v in ne:
                    step[v] -= 1
                    if step[v] == 1:
                        q.append(v)
        return ans


