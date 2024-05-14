class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        cnt = defaultdict(int)
        for v in tasks:
            cnt[v] += 1
        ans = 0
        for v in cnt.values():
            if v == 1:
                return -1
            ans += ((v + 2) // 3)
        return ans