class Solution:
    def minimumOperationsToMakeEqual(self, x: int, y: int) -> int:
        ans = 0
        q = deque([x])
        vis = {x}
        while q:
            for _ in range(len(q)):
                v = q.popleft()
                if v == y:
                    return ans
                for k in [5, 11]:
                    if not v % k and v // k not in vis:
                        vis.add(v // k)
                        q.append(v // k)
                for k in [-1, 1]:
                    if v + k not in vis:
                        vis.add(v + k)
                        q.append(v + k)
            ans += 1
        return ans