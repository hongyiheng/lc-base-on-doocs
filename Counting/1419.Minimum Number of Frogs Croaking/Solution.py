class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        def get_cur():
            cur = float('inf')
            for c in s:
                if cur >= mp[c]:
                    cur = mp[c]
                else:
                    return -1
            return mp['c'] - mp['k']

        s = ['c', 'r', 'o', 'a', 'k']
        mp = dict()
        for c in s:
            mp[c] = 0
        ans = 0
        for c in croakOfFrogs:
            if c not in croakOfFrogs:
                return -1
            mp[c] += 1
            cur = get_cur()
            if cur == -1:
                return -1
            ans = max(ans, cur)
        return ans if mp['c'] == mp['k'] else -1
