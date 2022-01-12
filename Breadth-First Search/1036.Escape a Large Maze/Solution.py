class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        edge, P, n = 1e6, 131, len(blocked)
        blocked_set = set()
        dirs = [[1, 0], [0, 1], [0, -1], [-1, 0]]
        for v in blocked:
            blocked_set.add(v[0] * P + v[1])
        max_area = n * n

        def dfs(a, b):
            visited, stk = set(), []
            stk.append(a)
            visited.add(a[0] * P + a[1])
            while stk and len(visited) <= max_area:
                cur = stk.pop()
                if cur[0] == b[0] and cur[1] == b[1]:
                    return True
                for v in dirs:
                    x = cur[0] + v[0]
                    y = cur[1] + v[1]
                    if x < 0 or x >= edge or y < 0 or y >= edge:
                        continue
                    hash_val = x * P + y
                    if hash_val in blocked_set:
                        continue
                    if hash_val in visited:
                        continue
                    stk.append([x, y])
                    visited.add(hash_val)
            return len(visited) > max_area

        return dfs(source, target) and dfs(target, source)
