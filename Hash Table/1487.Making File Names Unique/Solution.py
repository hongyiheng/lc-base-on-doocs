class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        mp = dict()
        vis = set()
        ans = []
        for v in names:
            s = v
            if v in vis:
                idx = mp.get(v, 1)
                s = v + "(" + str(idx) + ")"
                while s in mp:
                    idx += 1
                    s = v + "(" + str(idx) + ")"
                ans.append(s)
                mp[v] = idx + 1
            else:
                ans.append(s)
                mp[v] = 1
            vis.add(s)
        return ans