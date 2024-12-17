class Trie:
    def __init__(self):
        self.children = [None] * 26

    def insert(self, w):
        node = self
        for c in w:
            idx = ord(c) - ord('a')
            if not node.children[idx]:
                node.children[idx] = Trie()
            node = node.children[idx]

    def search(self, w):
        node = self
        for i, c in enumerate(w):
            idx = ord(c) - ord('a')
            if not node.children[idx]:
                return w[i:]
            if i == len(w) - 1:
                return None
            node = node.children[idx]
        return w


class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        @cache
        def dfs(i):
            if i >= n:
                return 0
            node = tr
            ans = inf
            for j in range(i, n):
                idx = ord(target[j]) - ord('a')
                if node.children[idx] is None:
                    break
                node = node.children[idx]
                nx = dfs(j + 1) + 1
                if nx < ans:
                    ans = nx
            return ans

        tr = Trie()
        for w in words:
            tr.insert(w)
        n = len(target)
        ans = dfs(0)
        return ans if ans < inf else -1





