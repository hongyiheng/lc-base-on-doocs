class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        events.sort(key=lambda e: (int(e[1]), e[0][2]))
        online = [0] * numberOfUsers
        ans = [0] * numberOfUsers
        for e, t, u in events:
            if e == 'MESSAGE':
                if u == 'HERE':
                    for i, v in enumerate(online):
                        if v > int(t):
                            continue
                        ans[i] += 1
                elif u == 'ALL':
                    for i in range(len(ans)):
                        ans[i] += 1
                else:
                    ids = u.split(" ")
                    for i in ids:
                        ans[int(i[2:])] += 1
            else:
                online[int(u)] = int(t) + 60
        return ans

