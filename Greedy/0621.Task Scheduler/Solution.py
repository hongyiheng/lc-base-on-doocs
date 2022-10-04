class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        mp = dict()
        for t in tasks:
            mp[t] = mp.get(t, 0) + 1
        q = []
        for k in mp:
            q.append([k, mp[k]])
        q.sort(key=lambda x:-x[1])
        cnt, mx = 0, q[0][1]
        for v in q:
            if v[1] == mx:
                cnt += 1
            else:
                break
        ans = (mx - 1) * (n + 1) + cnt
        return max(ans, len(tasks))
