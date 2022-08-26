class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        cnt = dict()
        for v in tasks:
            cnt[v] = cnt.get(v, 0) + 1
        ans = 0
        for k in cnt.keys():
            while cnt[k] > 0:
                ans += 1
                if cnt[k] < 2:
                    return -1
                if cnt[k] == 4:
                    cnt[k] -= 2
                else:
                    cnt[k] -= 3
        return ans