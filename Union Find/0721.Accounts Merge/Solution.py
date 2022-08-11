class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        def find(x):
            if x not in p:
                p[x] = x
            while x != p[x]:
                x = p[x]
            return x

        def union(a, b):
            p[find(a)] = find(b)

        p = {}
        email_name = {}
        g = defaultdict(list)
        for account in accounts:
            for i in range(1, len(account)):
                email_name[account[i]] = account[0]
                p[account[i]] = p.get(account[i], account[i])
                if i > 1:
                    union(account[i], account[i - 1])
        for email in p.keys():
            g[find(email)].append(email)
        ans = []
        for k in g.keys():
            g[k].sort()
            ans.append([email_name[find(k)]] + g[k])
        return ans