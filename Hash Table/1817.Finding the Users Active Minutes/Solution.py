class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        mp = defaultdict(set)
        for u, t in logs:
            mp[u].add(t)
        ans = [0] * k
        for v in mp.values():
            ans[len(v) - 1] += 1
        return ans