class Solution:
    def validStrings(self, n: int) -> List[str]:
        def dfs(s):
            if len(s) == n:
                ans.append(s[::])
                return
            if s[-1] == '1':
                s += '0'
                dfs(s)
                s = s[:-1]
            s += '1'
            dfs(s)

        ans = []
        dfs('0')
        dfs('1')
        return ans