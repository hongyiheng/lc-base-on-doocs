class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        def get_next(s):
            ans = set()
            for i in range(4):
                v = int(s[i])
                ans.add(s[:i] + (str(v + 1) if v < 9 else '0') + s[i + 1:])
                ans.add(s[:i] + (str(v - 1) if v > 0 else '9') + s[i + 1:])
            return ans

        dead = set(deadends)
        if target in dead or "0000" in dead:
            return -1
        vis = set()
        q = deque(["0000"])
        ans = 0
        while q:
            for _ in range(len(q)):
                cur = q.popleft()
                if cur == target:
                    return ans
                for ns in get_next(cur):
                    if ns in vis or ns in dead:
                        continue
                    vis.add(ns)
                    q.append(ns)
            ans += 1
        return -1