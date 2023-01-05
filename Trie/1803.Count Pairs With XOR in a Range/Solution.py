class Trie:
    def __init__(self):
        self.children = [None, None]
        self.cnt = 0

    def insert(self, x):
        node = self
        for i in range(15, -1, -1):
            v = x >> i & 1
            if not node.children[v]:
                node.children[v] = Trie()
            node = node.children[v]
            node.cnt += 1

    def search(self, x, mx):
        node = self
        ans = 0
        for i in range(15, -1, -1):
            if not node:
                return ans
            v = x >> i & 1
            if mx >> i & 1:
                if node.children[v]:
                    ans += node.children[v].cnt
                node = node.children[v ^ 1]
            else:
                node = node.children[v]
        return ans

class Solution:
    def countPairs(self, nums: List[int], low: int, high: int) -> int:
        ans = 0
        tree = Trie()
        for v in nums:
            ans += tree.search(v, high + 1) - tree.search(v, low)
            tree.insert(v)
        return ans