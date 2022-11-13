class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        n = len(creators)
        mp = dict()
        for i in range(n):
            id, idv, cnt = mp.get(creators[i], (None, 0, 0))
            if not id or idv < views[i] or (idv == views[i] and ids[i] < id):
                id = ids[i]
                idv = views[i]
            cnt += views[i]
            mp[creators[i]] = (id, idv, cnt)

        ans = list()
        mx = 0
        for k, v in mp.items():
            if v[2] >= mx:
                if v[2] > mx:
                    ans.clear()
                ans.append([k, v[0]])
                mx = v[2]
        return ans
