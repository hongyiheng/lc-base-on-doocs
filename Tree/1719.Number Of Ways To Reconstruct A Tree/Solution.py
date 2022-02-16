class Solution:
    def checkWays(self, pairs: List[List[int]]) -> int:
        mp = defaultdict(set)
        for son, p in pairs:
            mp[son].add(p)
            mp[p].add(son)
        root_cnt, root_val = -1, -1
        for son in mp:
            mp[son].add(son)
            if len(mp[son]) > root_cnt:
                root_cnt = len(mp[son])
                root_val = son
        if root_cnt != len(mp):
            return 0
        ans = 1
        for son in mp:
            if son == root_val:
                continue
            son_cnt = len(mp[son])
            parent_cnt = float('inf')
            parent_val = -1
            for p in mp[son]:
                if p != son and son_cnt <= len(mp[p]) < parent_cnt:
                    parent_cnt = len(mp[p])
                    parent_val = p
            if parent_val == -1 or not mp[son].issubset(mp[parent_val]):
                return 0
            if parent_cnt == son_cnt:
                ans = 2
        return ans
