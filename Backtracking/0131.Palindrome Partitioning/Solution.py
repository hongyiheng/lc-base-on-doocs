class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def check(word):
            if not word:
                return True
            l, r = 0, len(word) - 1
            while l < r:
                if word[l] != word[r]:
                    return False
                l += 1
                r -= 1
            return True

        def dfs(i, word, path):
            if i >= len(s):
                if not word:
                    ans.append(path[::])
                return

            word += s[i]
            if check(word):
                path.append(word)
                dfs(i + 1, "", path)
                path.pop()
            dfs(i + 1, word, path)

        ans = []
        dfs(0, "", [])
        return ans

