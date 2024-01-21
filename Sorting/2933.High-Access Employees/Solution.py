class Solution:
    def findHighAccessEmployees(self, access_times: List[List[str]]) -> List[str]:
        ans = set()
        q = [(k, int(t[:2]) * 60 + int(t[2:])) for k, t in access_times]
        q.sort(key=lambda x: x[1])
        cnt = defaultdict(list)
        for k, t in q:
            if k in ans:
                continue
            while cnt[k] and cnt[k][0] <= t - 60:
                cnt[k].pop(0)
            cnt[k].append(t)
            if len(cnt[k]) == 3:
                ans.add(k)
        return list(ans)



