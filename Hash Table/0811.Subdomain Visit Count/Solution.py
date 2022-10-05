class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        mp = dict()
        for s in cpdomains:
            ss = s.split(" ")
            num = int(ss[0])
            sss = ss[1].split(".")
            n = len(sss)
            k = sss[n - 1]
            mp[k] = mp.get(k, 0) + num
            for i in range(n - 2, -1, -1):
                k = sss[i] + "." + k
                mp[k] = mp.get(k, 0) + num
        ans = []
        for k in mp.keys():
            ans.append(str(mp[k]) + " " + k)
        return ans
