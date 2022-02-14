class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        n = len(s)
        ans = []

        def backTracking(path, cur):
            nonlocal s
            if len(path) == n:
                ans.append(path)
                return
            path += s[cur]
            backTracking(path, cur + 1)
            path = path[:-1]
            if not s[cur].isdigit():
                c = chr(ord(s[cur]) - 32) if ord(s[cur]) - ord('a') >= 0 else chr(ord(s[cur]) + 32)
                path += c
                backTracking(path, cur + 1)

        backTracking("", 0)
        return ans