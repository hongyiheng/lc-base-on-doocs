class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mp = dict()
        mp[2] = ["a", "b", "c"]
        mp[3] = ["d", "e", "f"]
        mp[4] = ["g", "h", "i"]
        mp[5] = ["j", "k", "l"]
        mp[6] = ["m", "n", "o"]
        mp[7] = ["p", "q", "r", "s"]
        mp[8] = ["t", "u", "v"]
        mp[9] = ["w", "x", "y", "z"]
        ans = []

        def dfs(cur, path):
            if len(path) == len(digits):
                ans.append(path)
                return
            idx = int(digits[cur])
            for c in mp[idx]:
                path += c
                dfs(cur + 1, path)
                path = path[:-1]

        if len(digits) == 0:
            return ans
        dfs(0, "")
        return ans